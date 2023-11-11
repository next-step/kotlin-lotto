package lotto.presentation

class InputManager {
    fun inputPay(): Int {
        println(INPUT_LOTTO_PAY_MESSAGE)
        return readln().toInt()
    }

    fun inputWinningNumbers(): List<Int> {
        println(INPUT_WINNING_NUMBER_MESSAGE)
        val winningNumberStr = readln()
        return winningNumberStr.split(",").map { it.toInt() }
    }

    companion object {
        const val INPUT_LOTTO_PAY_MESSAGE = "구입금액을 입력해 주세요."
        const val INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."
    }
}