package lotto.dto

import lotto.enum.Rank

class LottoRevenueCalculator(private val matchResult: LottoMatchResult) {
    fun calculateReturnRate(purchaseAmount: Double): Double {
        val revenue = calculateRevenue()
        return revenue / purchaseAmount
    }

    private fun calculateRevenue(): Double {
        var revenue = 0.0
        for (match in 3..6) {
            revenue += calculatePrizeForMatch(match) * matchResult.getMatchCount(match)
        }
        return revenue
    }

    private fun calculatePrizeForMatch(match: Int): Double {
        val rank = Rank.valueOf(match, match == 5 && matchResult.bonusMatchCount == 1)
        return rank.winningMoney.toDouble()
    }
}
