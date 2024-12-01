package lotto.domain

import kotlin.math.roundToInt

class WinningResult private constructor(
    val winningMatchCounts: List<LottoStatistics>,
    amount: Int,
) {
    val revenue: Int
    val rate: Int

    init {
        revenue = calculateRevenue(winningMatchCounts)
        rate = (revenue.toDouble() / amount.toDouble()).roundToInt()
    }

    private fun calculateRevenue(matchCounts: List<LottoStatistics>): Int {
        return matchCounts.sumOf { it.getTotalPrizeMoney() }
    }

    companion object {
        fun from(
            lottoRanks: Map<Rank, Int>,
            amount: Int,
        ): WinningResult {
            val ranks =
                Rank.entries
                    .filter { it !== Rank.MISS }
                    .map { LottoStatistics(lottoRanks[it] ?: 0, it) }
                    .sortedBy { it.rank.prizeAmount }
            return WinningResult(ranks, amount)
        }
    }
}
