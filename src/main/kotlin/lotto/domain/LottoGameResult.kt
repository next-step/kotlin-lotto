package lotto.domain

class LottoGameResult(private val lottoResult: Map<LottoRank, Int>) {
    fun makeLottoProfitRate(purchaseCount: LottoPurchaseCount): LottoProfitRate {
        val totalPrize = lottoResult.map { it.key.prize * it.value }.sum()
        return LottoProfitRate(totalPrize, LottoPurchaseAmount.fromLottoPurchaseCount(purchaseCount))
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
