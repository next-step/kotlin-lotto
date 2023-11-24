package lotto.view

import lotto.controller.EndLottoRequest
import lotto.controller.PurchaseRequest

object InputView {
    private const val PURCHASE_AMOUNT_QUESTION = "구입금액을 입력해 주세요."
    private const val MANUAL_LOTTO_COUNT_QUESTION = "수동으로 구매할 로또 수를 입력해 주세요."
    private const val MANUAL_LOTTO_NUMBERS_QUESTION = "수동으로 구매할 번호를 입력해 주세요."
    private const val WINNING_NUMBERS_QUESTION = "지난 주 당첨 번호를 입력해 주세요."
    private const val BONUS_NUMBER_QUESTION = "보너스 볼을 입력해 주세요."
    private const val LOTTO_NUMBER_DELIMITER = ", "

    val purchaseRequest: PurchaseRequest
        get() = PurchaseRequest(
            amount = getPurchaseAmount(),
            manualLottoNumbers = getManualLottoNumbers(),
        )

    val endLottoRequest: EndLottoRequest
        get() = EndLottoRequest(
            winningNumbers = getWinningNumbersInput(),
            bonusNumber = getBonusNumberInput()
        )

    private fun getPurchaseAmount(): Int {
        println(PURCHASE_AMOUNT_QUESTION)
        return readIntInput()
    }

    private fun getManualLottoNumbers(): List<List<Int>> {
        println()
        val count = getManualLottoCount()
        println()
        return getManualLottoNumbers(count)
    }

    private fun getWinningNumbersInput(): List<Int> {
        println()
        println(WINNING_NUMBERS_QUESTION)
        return parseLottoNumbers(readInput())
    }

    private fun getBonusNumberInput(): Int {
        println(BONUS_NUMBER_QUESTION)
        return readIntInput()
    }

    private fun readInput(): String = readlnOrNull()
        ?: throw IllegalArgumentException("입력 값이 없습니다.")

    private fun readIntInput(): Int = readInput().toIntOrNull() ?: throw IllegalArgumentException("숫자로 구성되지 않았습니다")

    private fun parseLottoNumbers(lottoNumbers: String): List<Int> =
        lottoNumbers
            .split(LOTTO_NUMBER_DELIMITER)
            .map { it.toIntOrNull() ?: throw IllegalArgumentException("로또 번호는 숫자로 구성되어야 합니다") }

    private fun getManualLottoCount(): Int {
        println(MANUAL_LOTTO_COUNT_QUESTION)
        return readIntInput()
    }

    private fun getManualLottoNumbers(count: Int): List<List<Int>> {
        println(MANUAL_LOTTO_NUMBERS_QUESTION)
        return List(count) { parseLottoNumbers(readInput()) }
    }
}
