package lotto.domain

internal data class LottoStatistics(
    private val buyMoney: Money,
    private val ranks: List<Rank>
) {
    val earningsRate: Double
        get() {
            val totalWinPrice = this.ranks.map { it.winningMoney }.sum()
            return 1.0 * totalWinPrice / buyMoney.value
        }

    fun getRankCount(rank: Rank): Int = this.ranks.filter { it == rank }.count()
}
