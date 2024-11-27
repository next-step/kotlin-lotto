package lotto.domain

class LottoRankMatchMap(val lottoRankMatchMap: Map<Rank, Int>) {
    fun getProfitRate(): Double {
        return getProfit().toDouble().div(getLottoPurchaseCount().times(Lotto.PRICE))
    }

    private fun getLottoPurchaseCount(): Int {
        return lottoRankMatchMap.map { it.value }.sum()
    }

    private fun getProfit(): Int {
        return lottoRankMatchMap.map { it.key.winningMoney.times(it.value) }.sum()
    }

    companion object {
        fun getLottoMatchMap(
            lottos: Lottos,
            winningNumbers: WinningNumbers,
        ): LottoRankMatchMap {
            return LottoRankMatchMap(Rank.entries.map { Pair(it, Rank.getRankCount(it, lottos, winningNumbers)) }.toMap())
        }
    }
}
