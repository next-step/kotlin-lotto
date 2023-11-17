package lotto.domain

import java.math.RoundingMode

class Ranks(val ranks: Map<Rank, Int>) {

    constructor(lottos: List<Rank>) : this(lottos.groupingBy { it }.eachCount())

    fun rateOfReturn(payment: Int): Double {
        val totalPrize = getTotalPrize()
        val ratio = (totalPrize.toDouble() / payment)
        return ratio.toBigDecimal().setScale(2, RoundingMode.DOWN).toDouble()
    }

    private fun getTotalPrize(): Int {
        var result = 0
        ranks.forEach { (rank, count) ->
            result += rank.prize * count
        }
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Ranks

        return ranks == other.ranks
    }

    override fun hashCode(): Int {
        return ranks.hashCode()
    }
}
