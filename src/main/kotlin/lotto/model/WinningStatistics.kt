package lotto.model

import kotlin.math.floor

class WinningStatistics private constructor(
    val winningStatistics: LinkedHashMap<WinningRank, Int>
) {

    fun calculateEarningRatio(paymentPrice: Int): Double {
        val earnings = winningStatistics.keys.sumOf { it.prizeMoney * (winningStatistics[it] ?: 0) }
        return floor(earnings / paymentPrice.toDouble() * 100.0) / 100
    }

    companion object {
        fun from(winningRanks: List<WinningRank>): WinningStatistics {
            val statistics = WinningRank.values().filter { it.isNotPrize() }
                .reversed()
                .associateWith { rank -> winningRanks.count { rank == it } }

            return WinningStatistics(statistics as LinkedHashMap<WinningRank, Int>)
        }
    }
}
