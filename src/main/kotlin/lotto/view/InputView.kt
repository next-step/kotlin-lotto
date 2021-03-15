package lotto.view

import lotto.model.Money
import lotto.model.number.BonusNumber
import lotto.model.number.WinningNumbers

object InputView {
    private fun readLine(message: String): String {
        var input: String? = null
        while (input.isNullOrBlank()) {
            println(message)
            input = readLine()
        }

        return input
    }

    fun readMoney(): Money {
        return Money(readLine("구입금액을 입력해 주세요.").toInt())
    }

    fun readWinningNumbers(): WinningNumbers {
        return WinningNumbers(
            readLine("지난 주 당첨 번호를 입력해 주세요.").split(",").map { it.toInt() }
        )
    }

    fun readBonusNumber(): BonusNumber {
        return BonusNumber.get(readLine("보너스 볼을 입력해 주세요.").toInt())
    }
}
