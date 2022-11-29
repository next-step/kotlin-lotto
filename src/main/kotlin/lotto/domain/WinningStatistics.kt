package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

data class WinningStatistics(
    val statistics: Map<Rank, Int> = mapOf()
) {
    fun getNumberOfMatchCount(rank: Rank): Int {
        return statistics[rank]!!
    }

    fun calculateRateOfReturn(amount: PurchaseAmount): BigDecimal {
        val bigDecimalAmount = BigDecimal(amount.getAmount())
        return getRewards().divide(bigDecimalAmount, DECIMAL_POINT_PLACE, RATE_OF_RETURN_ROUNDING_MODE)
    }

    private fun getRewards(): BigDecimal {
        return BigDecimal(statistics.map { it.key.getTotalWinningMoney(it.value) }.sum())
    }

    companion object {
        private const val DECIMAL_POINT_PLACE = 2
        private val RATE_OF_RETURN_ROUNDING_MODE = RoundingMode.FLOOR
    }
}
