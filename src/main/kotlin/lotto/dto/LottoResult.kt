package lotto.dto

import lotto.entity.Rank

class LottoResult private constructor(
    val rankToHowManyWins: Map<Rank, Int>,
    val rateOfReturn: Double,
) {
    companion object {
        fun of(rankToHowManyWins: Map<Rank, Int>, purchaseCost: Long): LottoResult {
            return LottoResult(
                rankToHowManyWins = rankToHowManyWins,
                rateOfReturn = calculateRateOfReturn(rankToHowManyWins.calculateTotalPrize(), purchaseCost.toDouble())
            )
        }

        private fun Map<Rank, Int>.calculateTotalPrize(): Double =
            this.entries.sumOf { (rank, howManyWins) -> howManyWins * rank.prize }.toDouble()

        private fun calculateRateOfReturn(totalPrize: Double, purchaseCost: Double): Double = totalPrize / purchaseCost
    }
}
