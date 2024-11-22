package lotto.domain

class LottoSeller(val purchasePrice: Int) {
    fun getLottoPurchaseCount(): Int {
        return purchasePrice / LOTTO_PRICE
    }

    fun getProfitMap(resultMap: Map<Int, Int>): Map<Int, Int> {
        val moneys = listOf(0, 0, 0, 5000, 50000, 1500000, 2000000000)
        return resultMap.map { Pair(it.key, moneys[it.key].times(it.value)) }.toMap()
    }

    fun getProfit(profitMap: Map<Int, Int>): Int {
        return profitMap.map { it.value }.sum()
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
