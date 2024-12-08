package lotto.model

import lotto.util.MathCalculator

class LottoMatchResults private constructor(private val lottoMatchResults: List<LottoMatchResult> = emptyList()) {
    fun findMatchCount(lottoPrize: LottoPrize): Int = lottoMatchResults.find { it.matchPrize == lottoPrize }?.count ?: 0

    val totalPrizeAmount: Int =
        lottoMatchResults.sumOf { it.matchPrize.prizeAmount * it.count }

    fun calculateReturnRate(purchaseAmount: Int): Double =
        MathCalculator.calculateRatio(
            numerator = totalPrizeAmount.toDouble(),
            denominator = purchaseAmount.toDouble(),
            decimalPlaces = 2,
        )

    companion object {
        fun from(lottoMatchResults: List<LottoMatchResult>) = LottoMatchResults(lottoMatchResults)
    }
}
