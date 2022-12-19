package lotto.interfaces.ui.console

import lotto.common.value.Money
import lotto.common.value.Money.Companion.toMoney

object InputConsole {

    private const val NUMBER_DELIMITER = ","

    fun queryPaymentPrice(): Money =
        try {
            println("구입금액을 입력해 주세요.")
            val inputPrice = readln().trim()
            inputPrice.toBigDecimal().toMoney()
        } catch (e: NumberFormatException) {
            println("숫자를 입력해주세요")
            queryPaymentPrice()
        }

    fun queryLastWeekWinLotteryNumbers(): Set<Int> =
        try {
            println("지난 주 당첨 번호를 입력해 주세요.")
            val input = readln().trim()
            val lastWeekWinLotteryNumbers = input.split(NUMBER_DELIMITER)
            lastWeekWinLotteryNumbers.map { it.trim().toInt() }.toSet()
        } catch (e: NumberFormatException) {
            println("숫자를 입력해주세요")
            queryLastWeekWinLotteryNumbers()
        }
}
