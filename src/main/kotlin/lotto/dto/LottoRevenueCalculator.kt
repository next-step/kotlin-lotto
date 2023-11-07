package lotto.dto

import lotto.domain.LottoConstants

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
        return when (match) {
            3 -> LottoConstants.PRIZE_MATCH_3.toDouble()
            4 -> LottoConstants.PRIZE_MATCH_4.toDouble()
            5 -> LottoConstants.PRIZE_MATCH_5.toDouble()
            6 -> LottoConstants.PRIZE_MATCH_6.toDouble()
            else -> 0.0
        }
    }
}
