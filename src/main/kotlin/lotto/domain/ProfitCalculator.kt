package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

object ProfitCalculator {
    fun calculateRatio(price: Int, winningStatistics: WinningStatistics): BigDecimal {
        var winningPrice = winningStatistics.calculateTotalWinningPrice()
        return BigDecimal(winningPrice).divide(BigDecimal(price), 2, RoundingMode.FLOOR)
    }
}