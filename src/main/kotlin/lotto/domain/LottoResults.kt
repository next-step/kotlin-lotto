package lotto.domain

import lotto.domain.vo.LottoResult

class LottoResults(private val results: List<LottoResult>) {
    fun getProfitRate(): Double {
        val profit = getProfit()
        val purchaseAmount = getPurchaseAmount()
        return (profit / purchaseAmount).toDouble()
    }

    fun isProfit(): Boolean = getProfitRate() > MARGIN_VALUE

    fun getWinResult(): List<LottoResult> {
        return results.filter { it.rank.isWin() }.sortedBy { it.rank.matchCount }
    }

    private fun getProfit(): Long = results.sumOf { it.rank.reward * it.count }

    private fun getPurchaseAmount(): Int = results.sumOf { it.count } * LottoPurchaseCount.PRICE_PER_LOTTO

    companion object {
        const val MARGIN_VALUE = 1.0

        fun from(result: Map<LottoRank, Int>): LottoResults {
            return LottoResults(LottoRank.entries.map { LottoResult(it, result.getOrDefault(it, 0)) })
        }
    }
}
