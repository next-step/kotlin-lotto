package lotto.domain

import lotto.dto.LottoMatchResult

class LottoRevenueCalculator(private val matchResult: LottoMatchResult, private val rankDeterminer: LottoRankDeterminer) {
    fun calculateReturnRate(purchaseAmount: Double): Double {
        val revenue = calculateRevenue()
        return revenue / purchaseAmount
    }

    private fun calculateRevenue(): Double {
        var revenue = 0.0
        for (match in 3..6) {
            val isBonusMatch = match == 5 && matchResult.bonusMatchCount > 0
            val rank = rankDeterminer.determineRank(match, isBonusMatch)
            revenue += rank.winningMoney * matchResult.getMatchCount(match)
        }
        return revenue
    }
}
