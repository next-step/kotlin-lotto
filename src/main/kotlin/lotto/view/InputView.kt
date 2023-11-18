package lotto.view

import lotto.domain.Input
import lotto.domain.Lotto
import lotto.domain.LottoCount
import lotto.domain.number.LottoNumber
import lotto.domain.purchase.LottoBuyingPrice

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
            is Input.WrongInput -> retry(numberValidationResult.errorMessage, ::readBuyingPrice)
            is Input.Success -> LottoBuyingPrice(numberValidationResult.data.trim().toInt())
        }
    }

    fun readManualLottoCount(): LottoCount {
        println(System.lineSeparator() + MANUAL_LOTTO_COUNT_MESSAGE)
        val userInput = readlnOrNull()
        val blankValidationResult = validateIsNullOrBlank(userInput)
        return when (val numberValidationResult = validateNumeric(blankValidationResult)) {
            is Input.WrongInput -> retry(numberValidationResult.errorMessage, ::readManualLottoCount)
            is Input.Success -> LottoCount(numberValidationResult.data.trim().toInt())
        }
    }

    fun readManualLottos(lottoCount: LottoCount): List<Lotto> {
        if (lottoCount.isZero()) {
            return emptyList()
        }
        println(System.lineSeparator() + MANUAL_LOTTO_NUMBERS_MESSAGE)
        return List(lottoCount.value) {
            readManualLotto()
        }
    }

    private fun readManualLotto(): Lotto {
        val userInput = readlnOrNull()
        return when (val blankValidationResult = validateIsNullOrBlank(userInput)) {
            is Input.WrongInput -> retry(blankValidationResult.errorMessage, ::readManualLotto)
            is Input.Success -> createLottoNumbers(blankValidationResult.data)
        }
    }

    fun readWinningLotto(): Lotto {
        println(System.lineSeparator() + WINNING_NUMBERS_MESSAGE)
        val userInput = readlnOrNull()
        return when (val blankValidationResult = validateIsNullOrBlank(userInput)) {
            is Input.WrongInput -> retry(blankValidationResult.errorMessage, ::readManualLotto)
            is Input.Success -> createLottoNumbers(blankValidationResult.data)
        }
    }

    fun readBonusBall(): LottoNumber {
        println(BONUS_BALL_MESSAGE)
        val userInput = readlnOrNull()
        val blankValidationResult = validateIsNullOrBlank(userInput)
        return when (val numberValidationResult = validateNumeric(blankValidationResult)) {
            is Input.WrongInput -> retry(numberValidationResult.errorMessage, ::readBonusBall)
            is Input.Success -> LottoNumber.from(numberValidationResult.data.trim().toInt())
        }
    }

    private fun <T> retry(errorMessage: String, retryFunction: () -> T): T {
        println(errorMessage)
        return retryFunction()
    }

    private fun validateIsNullOrBlank(userInput: String?): Input {
        if (userInput.isNullOrBlank()) {
            return Input.WrongInput("입력값이 존재하지 않습니다.")
        }
        return Input.Success(userInput)
    }

    private fun validateNumeric(userInput: Input): Input {
        return when (userInput) {
            is Input.WrongInput -> userInput
            is Input.Success -> getNumberInput(userInput)
        }
    }

    private fun getNumberInput(userInput: Input.Success): Input {
        if (userInput.data.toIntOrNull() == null) {
            return Input.WrongInput("입력값이 숫자가 아닙니다.")
        }
        return Input.Success(userInput.data)
    }

    private fun createLottoNumbers(userInput: String): Lotto {
        val splitInput = userInput.split(DELIMITER).toList()
        val validationResult = splitInput.map {
            val singleInput = Input.Success(it.trim())
            validateSingleNumber(singleInput)
        }

        if (hasWrongInput(validationResult)) {
            return retryLottoNumbersCreation(validationResult, userInput)
        }

        return createLottoNumbers(validationResult)
    }

    private fun validateSingleNumber(singleInput: Input.Success): Input {
        return when (val numberValidationResult = validateNumeric(singleInput)) {
            is Input.WrongInput -> numberValidationResult
            is Input.Success -> Input.Success(numberValidationResult.data.trim())
        }
    }

    private fun hasWrongInput(inputs: List<Input>): Boolean {
        return inputs.any { it is Input.WrongInput }
    }

    private fun retryLottoNumbersCreation(
        validationResult: List<Input>,
        userInput: String,
    ): Lotto {
        val errorMessage = validationResult
            .filterIsInstance<Input.WrongInput>()
            .first()
            .errorMessage
        return retry(errorMessage) { createLottoNumbers(userInput) }
    }

    private fun createLottoNumbers(validationResult: List<Input>): Lotto {
        val lottoNumbers = validationResult
            .filterIsInstance<Input.Success>()
            .map { it.data.toInt() }
        return Lotto.createFromNumbers(lottoNumbers)
    }
}
