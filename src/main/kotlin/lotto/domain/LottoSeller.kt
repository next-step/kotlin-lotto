package lotto.domain

class LottoSeller(
    val purchasePrice: Int,
    val setGenerator: SetGenerator = RandomSetGenerator(),
) {
    fun getLottoPurchaseCount(): Int {
        return purchasePrice / LOTTO_PRICE
    }

    fun sellLottos(): List<Lotto> {
        val lottoGenerator = LottoGenerator(setGenerator)
        return lottoGenerator.getLottos(getLottoPurchaseCount())
    }

    fun getLottoResult(
        lottos: List<Lotto>,
        winningNumbers: WinningNumbers,
    ): LottoResult {
        val lottoNumberMatcher = LottoNumberMatcher(winningNumbers)
        val lottoResultMapGenerator = LottoResultMapGenerator(lottoNumberMatcher)
        val resultMap = lottoResultMapGenerator.getResultMap(lottos)
        val profitMap = getProfitMap(resultMap)
        val profit = getProfit(profitMap)
        val profitRate = getProfitRate(profit)

        return LottoResult(lottos, resultMap, profitRate)
    }

    fun getProfitMap(resultMap: Map<Int, Int>): Map<Int, Int> {
        val moneys = listOf(0, 0, 0, 5000, 50000, 1500000, 2000000000)
        return resultMap.map { Pair(it.key, moneys[it.key].times(it.value)) }.toMap()
    }

    fun getProfit(profitMap: Map<Int, Int>): Int {
        return profitMap.map { it.value }.sum()
    }

    fun getProfitRate(profit: Int): Double {
        return profit.toDouble().div(purchasePrice)
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
