package lotto.interfaces.ui.console

import lotto.common.value.Money
import lotto.common.value.Money.Companion.toMoney

object InputConsole {

    private const val NUMBER_DELIMITER = ","

    fun queryPaymentPrice(): Money {
        println("구입금액을 입력해 주세요.")
        val inputPrice = queryNumber()
        return inputPrice.toBigDecimal().toMoney()
    }

    fun queryLastWeekWinLotteryNumbers(): Set<Int> {
        println()
        println("지난 주 당첨 번호를 입력해 주세요.")
        return queryLotteryNumbers()
    }

    private fun queryLotteryNumbers(): Set<Int> =
        try {
            val input = readln().trim()
            val lastWeekWinLotteryNumbers = input.split(NUMBER_DELIMITER)
            lastWeekWinLotteryNumbers.map { it.trim().toInt() }.toSet()
        } catch (e: NumberFormatException) {
            println("숫자를 입력해주세요")
            queryLotteryNumbers()
        }

    fun queryLastWeekBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return queryNumber()
    }

    private fun queryNumber(): Int {
        val number = readln().trim().toIntOrNull()
        if (number != null) {
            return number
        }
        println("숫자를 입력해주세요.")
        return queryNumber()
    }

    fun queryManualTicketCount(): Int {
        println()
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return queryNumber()
    }

    fun queryManualLotteryNumbers(manualTicketCount: Int): List<Set<Int>> {
        println()
        println("수동으로 구매할 번호를 입력해 주세요.")
        val mutableListOf = mutableListOf<Set<Int>>()
        repeat(manualTicketCount) {
            mutableListOf += queryLotteryNumbers()
        }
        return mutableListOf
    }
}
