package lotto.domain

class LottoResult(
    private val winningLotto: WinningLotto,
    private val lottos: List<Lotto>
) {
    val rankCntMap = mutableMapOf<LottoRank?, Int>()
    val rateOfReturn = returnRate(getTotalProfit())
    val message = resultMessage()

    init {
        setResultMap()
    }

    private fun setResultMap() {
        lottos.forEach {
            val rank = winningLotto.getRankOfLotto(it)
            rankCntMap[rank] = rankCntMap.getOrDefault(rank, 0) + 1
        }
    }

    private fun returnRate(profit: Int): Double {
        return profit.toDouble() / (lottos.size * Lotto.PRICE)
    }

    private fun getTotalProfit(): Int {
        return rankCntMap.keys.sumOf { rankCntMap[it]!! * (it?.winningMoney ?: LottoRank.DEFAULT_MONEY) }
    }

    private fun resultMessage(): String {
        return if (rateOfReturn < 1) LOSS else GAIN
    }

    companion object {
        private const val LOSS = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
        private const val GAIN = "(기준이 1이기 때문에 결과적으로 이득이는 의미임)"
    }
}
