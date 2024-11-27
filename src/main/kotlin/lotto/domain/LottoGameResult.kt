package lotto.domain

import java.util.EnumMap

class LottoGameResult(
    private val lottoResult: EnumMap<LottoRank, Int>,
    private val profitRateCalculator: ProfitRateCalculator,
) {
    constructor(lottoResult: Map<LottoRank, Int>, profitRateCalculator: ProfitRateCalculator) : this(
        EnumMap(lottoResult),
        profitRateCalculator,
    )

    fun calculateProfitRate(lottoPurchaseAmount: LottoPurchaseAmount): Double {
        val totalPrize = lottoResult.map { it.key.prize * it.value }.sum()
        return profitRateCalculator.calculate(totalPrize, lottoPurchaseAmount)
    }

    fun <T> extractResult(transform: (Pair<LottoRank, Int>) -> T): List<T> {
        return getLottoRankCounts()
            .toList()
            .sortedByDescending { it.first.rank }
            .map(transform)
    }

    private fun getLottoRankCounts(): Map<LottoRank, Int> =
        LottoRank.entries
            .filter { it != LottoRank.NO_RANK }
            .associateWith { lottoResult[it] ?: 0 }
}
