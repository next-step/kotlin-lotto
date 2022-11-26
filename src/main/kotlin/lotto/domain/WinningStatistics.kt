package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

data class WinningStatistics(
    private val statistics: Map<Rank, Int> = INITIAL_STATISTICS
) {
    fun add(matches: List<Int>): WinningStatistics {
        val ranks = matches.mapNotNull { Rank.valueOf(it) }
        val newWinningStatistics = statistics.toMutableMap()
        ranks.forEach {
            newWinningStatistics[it] = newWinningStatistics[it]!! + 1
        }

        return this.copy(statistics = newWinningStatistics)
    }

    fun getNumberOfMatchCount(rank: Rank): Int {
        return statistics.filterKeys { it == rank }.values.first()
    }

    fun calculateRateOfReturn(amount: PurchaseAmount): BigDecimal {
        val bigDecimalAmount = BigDecimal(amount.getAmount())
        return getRewards().divide(bigDecimalAmount, 2, RATE_OF_RETURN_ROUNDING_MODE)
    }

    private fun getRewards(): BigDecimal {
        return BigDecimal(statistics.map { it.key.getTotalWinningMoney(it.value) }.sum())
    }

    companion object {
        private const val INITIAL_COUNT = 0
        private val INITIAL_STATISTICS = Rank.values().associateWith { INITIAL_COUNT }
        private val RATE_OF_RETURN_ROUNDING_MODE = RoundingMode.FLOOR
    }
}
