package lotto.domain

class Bank {
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
