package lotto.domain

class LottoProfitRate(
    lottoResult: LottoResult,
    purchaseAmount: Int,
) {
    val profitRate: Float = calculateProfitRate(lottoResult, purchaseAmount)

    private fun calculateProfitRate(
        lottoResult: LottoResult,
        purchaseAmount: Int,
    ): Float {
        val totalProfit =
            lottoResult.prizeCounts
                .map { (prize, count) ->
                    count * prize.money
                }.sum()
        return totalProfit.toFloat() / purchaseAmount
    }
}
