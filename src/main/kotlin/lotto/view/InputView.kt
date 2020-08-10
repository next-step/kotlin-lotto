package lotto.view

import lotto.model.lotto.LottoNumber
import lotto.model.lotto.WinnerNumbers
import lotto.model.lotto.toNumbers

class InputView(
    val input: () -> String? = { readLine() }
) {
    private fun showQuestion(question: String): String {
        println(question)
        return input() ?: ""
    }

    fun getBuyPrice() = showQuestion(INPUT_PRICE).toIntOrNull() ?: 0

    fun getWinnerNumbers(): WinnerNumbers = try {
        WinnerNumbers(getWinningNumbers().toNumbers(), LottoNumber.from(getBonusBall()))
    } catch (e: Exception) {
        println("잘못입력하셨습니다. 다시입력해주세요.")
        getWinnerNumbers()
    }

    private fun getWinningNumbers() = showQuestion(INPUT_WINNING_NUMBERS)

    private fun getBonusBall() = showQuestion(INPUT_BONUS_NUMBER).toIntOrNull() ?: 0

    companion object {
        private const val INPUT_PRICE = "금액을 입력하세요"
        private const val INPUT_WINNING_NUMBERS = "당첨 번호를 입력하세요"
        private const val INPUT_BONUS_NUMBER = "보너스 볼을 입력하세요"
    }
}
