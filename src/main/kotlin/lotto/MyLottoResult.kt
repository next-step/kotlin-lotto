package lotto

data class MyLottoResult(private val result: Map<LottoWinnerRank, Int>) {
    val totalEarning = result
        .map { it.key.price * it.value }
        .sum()

    fun getCount(ranking: LottoWinnerRank): Int {
        return result.getOrDefault(ranking, 0)
    }
}
