package lotto.view

import lotto.domain.LottoRank

class LottoResult(
    lottoRanks: List<LottoRank>,
) {
    val rankCounts: Map<LottoRank, Int> =
        LottoRank.associateWithCount { rank ->
            lottoRanks.count { it == rank }
        }

    fun calculateProfitRate(purchaseAmount: Int): Float {
        val totalProfit =
            rankCounts
                .map { (prize, count) ->
                    count * prize.money
                }.sum()
        return totalProfit.toFloat() / purchaseAmount
    }
}
