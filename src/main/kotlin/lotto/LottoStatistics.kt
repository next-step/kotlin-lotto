package lotto

internal data class LottoStatistics(
    val buyMoney: Money,
    val rankCounts: Map<Rank, Int>
) {

    val earningsRate: Double
        get() {
            val totalWinPrice = rankCounts.entries.map {
                it.key.winningMoney * it.value
            }.sum()

            return 1.0 * totalWinPrice / buyMoney.value
        }
}
