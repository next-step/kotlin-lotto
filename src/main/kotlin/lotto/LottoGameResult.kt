package lotto

class LottoGameResult(private val lottoResult: Map<LottoRank, Int>) {
    fun makeLottoProfitRate(purchaseCount: LottoPurchaseCount): LottoProfitRate {
        val totalPrize = lottoResult.map { it.key.prize * it.value }.sum()
        return LottoProfitRate(totalPrize, LottoPurchaseAmount.fromLottoPurchaseCount(purchaseCount))
    }
}
