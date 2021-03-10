package lotto.domain

import kotlin.math.round

internal data class LottoStatistics(
    private val buyMoney: Money,
    private val ranks: List<Rank>
) {
    val earningsRate: Double
        get() {
            val totalWinPrice = this.ranks.map { it.winningMoney }.sum()
            return round(1.0 * totalWinPrice / buyMoney.value * 100) / 100
        }

    fun getRankCount(rank: Rank): Int = this.ranks.filter { it == rank }.count()
}
