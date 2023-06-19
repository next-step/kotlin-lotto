package lotto.controller

import lotto.domain.Prize

class MatchResult(
    private val matches: Map<Prize, Int>
) {
    private fun calculateTotalPrice(): Int {
        return matches.entries.sumOf { (prize, count) -> prize.amount * count }
    }

    fun calculateEarningRate(money: Int): Double {
        val totalPrize = calculateTotalPrice()
        return totalPrize.toDouble() / money
    }

    fun getNumberOfMatchesForPrize(prize: Prize): Int {
        return matches[prize] ?: 0
    }

    fun isProfit(earningRate: Double): Boolean {
        return earningRate >= 1
    }
}
