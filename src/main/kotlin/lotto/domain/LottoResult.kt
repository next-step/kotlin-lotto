package lotto.domain

import lotto.domain.Lotto.Companion.NUMBER_OF_NUMBER

class LottoResult(
    val lottos: List<Lotto>,
    val lottoResultMap: Map<Int, Int>,
    val profitRate: Double,
) {
    companion object {
        fun getResultMap(
            lottos: List<Lotto>,
            winningNumbers: WinningNumbers,
        ): Map<Int, Int> {
            val matchCounts = lottos.map { winningNumbers.matchNumbers(it) }
            val pairs = List(NUMBER_OF_NUMBER + 1) { it }.map { Pair(it, getNumberCount(matchCounts, it)) }
            return pairs.map { it.first to it.second }.toMap()
        }

        private fun getNumberCount(
            numbers: List<Int>,
            matchNumber: Int,
        ): Int {
            return numbers.filter { it == matchNumber }.size
        }

        fun getLottoResult(
            lottos: List<Lotto>,
            winningNumbers: WinningNumbers,
            purchasePrice: Int,
        ): LottoResult {
            val resultMap = LottoResult.getResultMap(lottos, winningNumbers)
            val profitMap = getProfitMap(resultMap)
            val profit = getProfit(profitMap)
            val profitRate = getProfitRate(profit, purchasePrice)

            return LottoResult(lottos, resultMap, profitRate)
        }

        fun getProfitMap(resultMap: Map<Int, Int>): Map<Int, Int> {
            val moneys = listOf(0, 0, 0, 5000, 50000, 1500000, 2000000000)
            return resultMap.map { Pair(it.key, moneys[it.key].times(it.value)) }.toMap()
        }

        fun getProfit(profitMap: Map<Int, Int>): Int {
            return profitMap.map { it.value }.sum()
        }

        fun getProfitRate(
            profit: Int,
            purchasePrice: Int,
        ): Double {
            return profit.toDouble().div(purchasePrice)
        }
    }
}
