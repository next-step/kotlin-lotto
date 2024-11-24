package lotto.domain

class LottoGameResult(
    private val lottoResult: Map<LottoRank, Int>,
    private val profitRateCalculator: ProfitRateCalculator,
) {
    fun calculateProfitRate(lottoPurchaseAmount: LottoPurchaseAmount): Double {
        val totalPrize = lottoResult.map { it.key.prize * it.value }.sum()
        return profitRateCalculator.calculate(totalPrize, lottoPurchaseAmount)
    }

    fun extractResult(): List<Pair<LottoRank, Int>> {
        return getLottoRankCounts()
            .toList()
            .sortedByDescending { it.first.rank }
    }

    private fun getLottoRankCounts() =
        LottoRank.entries
            .filter { it != LottoRank.NO_RANK }
            .associateWith { lottoResult[it] ?: 0 }
}
