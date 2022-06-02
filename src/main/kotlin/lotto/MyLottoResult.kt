package lotto

data class MyLottoResult(private val result: Map<LottoWinnerRank, Int>) {
    private val totalEarning = result
        .map { it.key.price * it.value }
        .sum()

    private val totalLottoCount = result.map { it.value }.sum()

    fun getProfit(): Double {
        val totalEarningByLotto = this.totalEarning
        return totalEarningByLotto.toDouble() / (totalLottoCount * LottoShop.LOTTO_PRICE).toDouble()
    }

    fun getCount(ranking: LottoWinnerRank): Int {
        return result.getOrDefault(ranking, 0)
    }
}
