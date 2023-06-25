package lotto.domain

class LottoResult(
    private val winningLotto: WinningLotto,
    private val lottos: List<Lotto>
) {
    val rankCntMap = mutableMapOf<LottoRank?, Int>()
    var rateOfReturn = 0.0

    init {
        setResultMap()
        setReturnRate(getTotalProfit())
    }

    private fun setResultMap() {
        lottos.forEach {
            val rank = winningLotto.rankOfLotto(it)
            rankCntMap[rank] = rankCntMap.getOrDefault(rank, 0) + 1
        }
    }

    private fun setReturnRate(profit: Int) {
        rateOfReturn = profit.toDouble() / (lottos.size * Lotto.PRICE)
    }

    private fun getTotalProfit(): Int {
        return rankCntMap.keys.sumOf { rankCntMap[it]!! * (it?.winningMoney ?: LottoRank.DEFAULT_MONEY) }
    }

}
