package lotto.view

import lotto.domain.LottoRank

class LottoResult(
    lottoRanks: List<LottoRank>,
) {
    val rankCounts: Map<LottoRank, Int> = generateRankCounts(lottoRanks)

    private fun generateRankCounts(lottoRanks: List<LottoRank>): Map<LottoRank, Int> {
        val prizeCountsMap = lottoRanks.groupBy { it.matchCount }

        return LottoRank.entries.associateWith { prize ->
            prizeCountsMap[prize.matchCount]?.size ?: 0
        }
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
