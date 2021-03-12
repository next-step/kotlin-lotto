package lotto.domain

import kotlin.math.round

internal data class LottoStatistics(
    private val buyMoney: Money,
    private val ranks: List<Rank>
) {
    val earningsRate: Double
        get() {
            val totalWinPrice = this.ranks.map { it.winningMoney }.sum()
            return totalWinPrice.toDouble().div(buyMoney.value).round(2)
        }

    fun getRankCount(rank: Rank): Int = this.ranks.filter { it == rank }.count()
}

fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return round(this * multiplier) / multiplier
}
