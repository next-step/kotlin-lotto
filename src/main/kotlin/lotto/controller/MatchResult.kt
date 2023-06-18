package lotto.controller

import lotto.domain.Prize

class MatchResult(
    private val matches: Map<Int, Int>
) {
    private fun calculateTotalPrice(): Int {
        return Prize.calculateTotalPrice(matches)
    }

    fun calculateEarningRate(money: Int): Double {
        val totalPrize = calculateTotalPrice()
        return totalPrize.toDouble() / money
    }

    fun getNumberOfMatchesForPrize(prize: Prize): Int {
        return matches[prize.matchCount] ?: 0
    }
}
