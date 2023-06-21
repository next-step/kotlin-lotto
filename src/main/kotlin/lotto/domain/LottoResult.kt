package lotto.domain

class LottoResult(
    private val winningNums: List<LottoNumber>,
    private val lottos: List<Lotto>
) {
    private val resultMap = mutableMapOf<LottoRank?, Int>()
    var rateOfReturn: Double = 0.0

    init {
        setResultMap()
        setReturn(getTotalProfit())
    }

    override fun toString(): String {
        var result = ""
        LottoRank.ranks().forEach {
            val cnt = resultMap.getOrDefault(it, 0)
            println("${it.numOfMatch}" + "개 일치 (${it.winningMoney}" + "원)- $cnt" + "개\n")
        }
        result += "총 수익률은 ${String.format("%.2f", rateOfReturn)}" + "입니다."
        result += if (rateOfReturn < 1) LOSS else GAIN
        return result
    }

    private fun setResultMap() {
        lottos.forEach {
            val numOfMatch = it.numOfMatch(winningNums)
            val rank = LottoRank.getRankByNumOfMatch(numOfMatch)
            resultMap[rank] = resultMap.getOrDefault(rank, 0) + 1
        }
    }

    private fun getTotalProfit(): Int {
        return resultMap.keys.sumOf { resultMap[it]!! * (it?.winningMoney ?: LottoRank.DEFAULT_MONEY) }
    }

    private fun setReturn(profit: Int) {
        rateOfReturn = profit.toDouble() / (lottos.size * Lotto.PRICE)
    }

    companion object {
        private const val LOSS = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
        private const val GAIN = "(기준이 1이기 때문에 결과적으로 이득이는 의미임)"
    }
}