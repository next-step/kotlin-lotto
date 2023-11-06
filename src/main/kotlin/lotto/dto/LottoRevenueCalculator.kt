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
            val count = matchResult.getMatchCount(match)
            revenue += when (match) {
                3 -> LottoConstants.PRIZE_MATCH_3.toDouble() * count
                4 -> LottoConstants.PRIZE_MATCH_4.toDouble() * count
                5 -> LottoConstants.PRIZE_MATCH_5.toDouble() * count
                6 -> LottoConstants.PRIZE_MATCH_6.toDouble() * count
                else -> 0.0
            }
        }
        return revenue
    }
}
