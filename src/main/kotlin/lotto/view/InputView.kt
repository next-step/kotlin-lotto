package lotto.view

import lotto.model.Numbers
import lotto.model.toNumbers

class InputView(
    val input: () -> String? = { readLine() }
) {
    private fun showQuestion(question: String): String {
        println(question)
        return input() ?: ""
    }

    fun getBuyPrice() = showQuestion(INPUT_PRICE).toIntOrNull() ?: 0

    fun getWinningNumbers(): Numbers = try {
        showQuestion(INPUT_WINNING_NUMBERS).toNumbers()
    } catch (e: Exception) {
        println("잘못입력하셨습니다. 다시입력해주세요.")
        getWinningNumbers()
    }

    companion object {
        private const val INPUT_PRICE = "금액을 입력하세요"
        private const val INPUT_WINNING_NUMBERS = "당첨 번호를 입력하세요"
    }
}
