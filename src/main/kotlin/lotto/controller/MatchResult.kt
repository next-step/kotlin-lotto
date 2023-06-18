package lotto.controller

import lotto.domain.Prize

class MatchResult(
    private val matches: Map<Int, Int>
) {
    private fun calculateTotalPrice(): Int {
        return matches.entries.sumOf { (matchCount, count) ->
            Prize.prizeForMatchCount(matchCount)?.amount?.times(count) ?: 0
        }
    }

    fun calculateEarningRate(money: Int): Double {
        val totalPrize = calculateTotalPrice()
        return totalPrize.toDouble() / money
    }

    fun getNumberOfMatchesForPrize(prize: Prize): Int {
        return matches[prize.matchCount] ?: 0
    }
}
