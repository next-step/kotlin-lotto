package lotto.domain

import lotto.domain.vo.LottoResult

class LottoResults(private val results: List<LottoResult>) {
    fun calculateProfitRate(): Double {
        val profit = getSumOfProfit()
        val purchaseAmount = getSumOfPurchasePrice()
        return (profit / purchaseAmount).toDouble()
    }

    fun isProfit(): Boolean = calculateProfitRate() > MARGIN_VALUE

    fun filterWinResults(): List<LottoResult> {
        return results.filter { it.rank.isWin() }.sortedBy { it.rank.matchCount }
    }

    private fun getSumOfProfit(): Long = results.sumOf { it.rank.reward * it.count }

    private fun getSumOfPurchasePrice(): Int = results.sumOf { it.count } * LottoPurchaseCount.PRICE_PER_LOTTO

    companion object {
        const val MARGIN_VALUE = 1.0

        fun from(lottoRankCountMap: Map<LottoRank, Int>): LottoResults {
            return LottoResults(LottoRank.entries.map { LottoResult(it, lottoRankCountMap.getOrDefault(it, 0)) })
        }
    }
}
