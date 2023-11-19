package lotto.view

import lotto.domain.Input
import lotto.domain.Lotto
import lotto.domain.LottoCount
import lotto.domain.LottoCountResult
import lotto.domain.LottoResult
import lotto.domain.WinningLotto
import lotto.domain.WinningLottoResult
import lotto.domain.number.LottoNumber
import lotto.domain.number.LottoNumberResult
import lotto.domain.purchase.LottoBuyingPrice
import lotto.domain.purchase.LottoBuyingPriceResult

object InputView {

    private const val DELIMITER = ","
    private const val BUYING_PRICE_MESSAGE = "구입금액을 입력해 주세요."
    private const val MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요."
    private const val MANUAL_LOTTO_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요."
    private const val WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."
    private const val BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요."

    fun readBuyingPrice(): LottoBuyingPrice {
        println(BUYING_PRICE_MESSAGE)
        val userInput = readlnOrNull()
        val blankValidationResult = validateIsNullOrBlank(userInput)
        return when (val numberValidationResult = validateNumeric(blankValidationResult)) {
            is Input.Failure -> retry(numberValidationResult.errorMessage, ::readBuyingPrice)
            is Input.Success -> createLottoBuyingPrice(numberValidationResult.data)
        }
    }

    fun readManualLottoCount(buyingPrice: LottoBuyingPrice): LottoCount {
        println(System.lineSeparator() + MANUAL_LOTTO_COUNT_MESSAGE)
        val userInput = readlnOrNull()
        val blankValidationResult = validateIsNullOrBlank(userInput)
        val lottoCount = createNumberLottoCount(blankValidationResult, buyingPrice)

        return when (val priceResult = buyingPrice.validateManualLottoPurchase(lottoCount)) {
            is LottoBuyingPriceResult.Failure -> retry(priceResult.errorMessage) { readManualLottoCount(buyingPrice) }
            is LottoBuyingPriceResult.Success -> lottoCount
        }
    }

    fun readManualLotto(lottoCount: LottoCount, count: Int): Lotto {
        if (count == 0) {
            println(System.lineSeparator() + MANUAL_LOTTO_NUMBERS_MESSAGE)
        }
        return when (val lottoResult = readSingleLotto()) {
            is LottoResult.Failure -> retry(lottoResult.errorMessage) { readManualLotto(lottoCount, count) }
            is LottoResult.Success -> lottoResult.data
        }
    }

    fun readWinningLottoNumbers(): Lotto {
        println(System.lineSeparator() + WINNING_NUMBERS_MESSAGE)
        return when (val lottoResult = readSingleLotto()) {
            is LottoResult.Failure -> retry(lottoResult.errorMessage, ::readWinningLottoNumbers)
            is LottoResult.Success -> lottoResult.data
        }
    }

    fun createWinningLotto(winningLottoNumbers: Lotto): WinningLotto {
        val bonusBall = readBonusBall(winningLottoNumbers)
        return when (val winningLottoResult = WinningLotto.createResult(winningLottoNumbers, bonusBall)) {
            is WinningLottoResult.Failure -> retry(winningLottoResult.errorMessage) { createWinningLotto(winningLottoNumbers) }
            is WinningLottoResult.Success -> winningLottoResult.data
        }
    }

    private fun <T> retry(errorMessage: String, retryFunction: () -> T): T {
        println(errorMessage)
        return retryFunction()
    }

    private fun validateIsNullOrBlank(userInput: String?): Input {
        if (userInput.isNullOrBlank()) {
            return Input.Failure("입력값이 존재하지 않습니다.")
        }
        return Input.Success(userInput)
    }

    private fun validateNumeric(userInput: Input): Input {
        return when (userInput) {
            is Input.Failure -> userInput
            is Input.Success -> getNumberInput(userInput)
        }
    }

    private fun getNumberInput(userInput: Input.Success): Input {
        if (userInput.data.toIntOrNull() == null) {
            return Input.Failure("입력값이 숫자가 아닙니다.")
        }
        return Input.Success(userInput.data)
    }

    private fun createLottoBuyingPrice(userInput: String): LottoBuyingPrice {
        return when (val buyingPriceResult = LottoBuyingPrice.createResult(userInput.trim().toInt())) {
            is LottoBuyingPriceResult.Failure -> retry(buyingPriceResult.errorMessage, ::readBuyingPrice)
            is LottoBuyingPriceResult.Success -> buyingPriceResult.data
        }
    }

    private fun createNumberLottoCount(
        blankValidationResult: Input,
        buyingPrice: LottoBuyingPrice,
    ): LottoCount {
        return when (val numberValidationResult = validateNumeric(blankValidationResult)) {
            is Input.Failure -> retry(numberValidationResult.errorMessage) { readManualLottoCount(buyingPrice) }
            is Input.Success -> createLottoCount(numberValidationResult.data, buyingPrice)
        }
    }

    private fun createLottoCount(userInput: String, buyingPrice: LottoBuyingPrice): LottoCount {
        return when (val lottoCountResult = LottoCount.createResult(userInput.trim().toInt())) {
            is LottoCountResult.Failure -> retry(lottoCountResult.errorMessage) { readManualLottoCount(buyingPrice) }
            is LottoCountResult.Success -> lottoCountResult.data
        }
    }

    private fun readSingleLotto(): LottoResult {
        val userInput = readlnOrNull()
        return when (val blankValidationResult = validateIsNullOrBlank(userInput)) {
            is Input.Failure -> LottoResult.Failure(blankValidationResult.errorMessage)
            is Input.Success -> createLotto(blankValidationResult.data)
        }
    }

    private fun createLotto(validInput: String): LottoResult {
        return when (val createResult = createLottoNumbers(validInput)) {
            is LottoResult.Failure -> LottoResult.Failure(createResult.errorMessage)
            is LottoResult.Success -> createResult
        }
    }

    private fun createLottoNumbers(userInput: String): LottoResult {
        val splitInput = userInput.split(DELIMITER).toList()
        val validationResult = splitInput.map {
            val singleInput = Input.Success(it.trim())
            validateSingleNumber(singleInput)
        }

        if (validationResult.any { it is Input.Failure }) {
            return createFailLottoResult(validationResult)
        }
        return createLottoNumbers(validationResult)
    }

    private fun validateSingleNumber(singleInput: Input.Success): Input {
        return when (val numberValidationResult = validateNumeric(singleInput)) {
            is Input.Failure -> numberValidationResult
            is Input.Success -> Input.Success(numberValidationResult.data.trim())
        }
    }

    private fun createFailLottoResult(
        validationResult: List<Input>,
    ): LottoResult {
        val errorMessage = validationResult
            .filterIsInstance<Input.Failure>()
            .first()
            .errorMessage
        return LottoResult.Failure(errorMessage)
    }

    private fun createLottoNumbers(validationResult: List<Input>): LottoResult {
        val lottoNumbers = validationResult
            .filterIsInstance<Input.Success>()
            .map { it.data.toInt() }

        return Lotto.createFromNumbers(lottoNumbers)
    }

    private fun readBonusBall(winningLotto: Lotto): LottoNumber {
        println(BONUS_BALL_MESSAGE)
        val userInput = readlnOrNull()
        val blankValidationResult = validateIsNullOrBlank(userInput)
        return when (val numberValidationResult = validateNumeric(blankValidationResult)) {
            is Input.Failure -> retry(numberValidationResult.errorMessage) { readBonusBall(winningLotto) }
            is Input.Success -> createLottoNumber(numberValidationResult.data, winningLotto)
        }
    }

    private fun createLottoNumber(number: String, winningLotto: Lotto): LottoNumber {
        return when (val lottoNumberResult = LottoNumber.createResult(number.trim().toInt())) {
            is LottoNumberResult.Failure -> retry(lottoNumberResult.errorMessage) { readBonusBall(winningLotto) }
            is LottoNumberResult.Success -> lottoNumberResult.data
        }
    }
}
