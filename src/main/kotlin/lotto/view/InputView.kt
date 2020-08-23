package lotto.view

import lotto.model.lotto.LottoNumber
import lotto.model.lotto.Numbers
import lotto.model.lotto.WinnerNumbers
import lotto.model.lotto.toNumbers

class InputView(
    val input: () -> String? = { readLine() }
) {
    private fun getQuestionAnswer(question: String): String {
        println(question)
        return input() ?: ""
    }

    fun getBuyPrice() = getQuestionAnswer(INPUT_PRICE).toIntOrNull() ?: 0

    fun getWinnerNumbers(): WinnerNumbers = try {
        WinnerNumbers(getWinningNumbers().toNumbers(), LottoNumber.from(getBonusBall()))
    } catch (e: Exception) {
        println(INPUT_ERROR_TRY_AGAIN)
        getWinnerNumbers()
    }

    fun getManualNumberLottoCount(availableLottoCount: Int): Int =
        try {
            val count = getManualNumberCount().toInt()
            require(availableLottoCount >= count) { "구매 할 수 있는 로또를 초과하였습니다." }
            count
        } catch (e: Exception) {
            println(INPUT_ERROR_TRY_AGAIN)
            getManualNumberLottoCount(availableLottoCount)
        }

    fun getManualNumbers(manualLottoCount: Int): List<Numbers> {
        println(INPUT_MANUAL_NUMBER)
        return (1..manualLottoCount).map {
            getManualNumber()
        }
    }

    private fun getManualNumber(): Numbers =
        try {
            (input() ?: "").toNumbers()
        } catch (e: Exception) {
            println(INPUT_ERROR_TRY_AGAIN)
            getManualNumber()
        }

    private fun getManualNumberCount() = getQuestionAnswer(INPUT_MANUAL_NUMBER_COUNT)

    private fun getWinningNumbers() = getQuestionAnswer(INPUT_WINNING_NUMBERS)

    private fun getBonusBall() = getQuestionAnswer(INPUT_BONUS_NUMBER).toIntOrNull() ?: 0

    companion object {

        private const val INPUT_ERROR_TRY_AGAIN = "잘못입력하셨습니다. 다시입력해주세요."
        private const val INPUT_PRICE = "금액을 입력하세요"
        private const val INPUT_WINNING_NUMBERS = "당첨 번호를 입력하세요"
        private const val INPUT_BONUS_NUMBER = "보너스 볼을 입력하세요"
        private const val INPUT_MANUAL_NUMBER_COUNT = "수동으로 입력할 로또의 수 입력하세요"
        private const val INPUT_MANUAL_NUMBER = "수동으로 구매할 번호를 입력해 주세요."
    }
}
