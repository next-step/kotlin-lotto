package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

data class WinningStatistics(
    private val statistics: Map<Rank, Int> = INITIAL_STATISTICS
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
        private const val INITIAL_COUNT = 0
        private const val DECIMAL_POINT_PLACE = 2
        private val INITIAL_STATISTICS = Rank.values().associateWith { INITIAL_COUNT }
        private val RATE_OF_RETURN_ROUNDING_MODE = RoundingMode.FLOOR

        fun create(lottoNumbersList: List<LottoNumbers>, winningLottoNumbers: WinningLottoNumbers): WinningStatistics {
            val allNumberOfMatches = winningLottoNumbers.getAllNumberOfMatches(lottoNumbersList)
            val ranks = allNumberOfMatches.mapNotNull { Rank.valueOf(it) }

            return WinningStatistics(statistics = makeStatistics(ranks))
        }

        private fun makeStatistics(ranks: List<Rank>): Map<Rank, Int> {
            val statistics = INITIAL_STATISTICS.toMutableMap()

            ranks.forEach {
                statistics[it] = statistics[it]!! + 1
            }

            return statistics.toMap()
        }
    }
}
