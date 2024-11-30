package lotto.domain

import kotlin.math.roundToInt

class WinningResult(
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
}
