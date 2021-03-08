package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

object ProfitCalculator {
    fun calculateRatio(price: Int, winningStatistics: WinningStatistics): BigDecimal {
        var totalPrice = 0
        for (entry in winningStatistics.ticketCounts) {
            val lotteryMatchType = entry.key
            val ticketCount = entry.value

            totalPrice = lotteryMatchType.winningPrice * ticketCount
        }
        return BigDecimal(totalPrice).divide(BigDecimal(price), 2, RoundingMode.FLOOR)
    }
}