package lotto.view

import lotto.model.Money
import lotto.model.WinningNumbers

object InputView {
    fun readMoney(message: String): Money {
        return Money(readLine(message).toInt())
    }

    fun readWinningNumbers(message: String): WinningNumbers {
        return WinningNumbers.from(
            readLine(message).split(",").map { it.toInt() }
        )
    }

    private fun readLine(message: String): String {
        var input: String? = null
        while (input.isNullOrBlank()) {
            println(message)
            input = readLine()
        }

        return input
    }
}
