package lotto.domain

class LottoResult(
    private val results: Map<LottoRank, Int>,
    private val lottoCount: Int,
) {

    constructor(ranks: List<LottoRank>, lottoCount: Int) : this(ranks.groupingBy { it }.eachCount(), lottoCount)

    fun getRankCount(rank: LottoRank): Int {
        return results[rank] ?: 0
    }

    fun getProfitRate(): Double {
        val totalProfit = getTotalProfit().toDouble()
        return (totalProfit / (lottoCount * Lotto.LOTTO_PRICE))
    }

    private fun getTotalProfit(): Int {
        return LottoRank.values().sumOf { it.price * getLottoRankCount(it) }
    }

    private fun getLottoRankCount(lottoRank: LottoRank): Int {
        return results[lottoRank] ?: ZERO
    }

    companion object {
        private const val ZERO = 0
    }
}
