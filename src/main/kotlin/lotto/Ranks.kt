package lotto

import java.math.BigDecimal
import java.math.RoundingMode

typealias MatchedCount = Int

data class Ranks(private val values: Map<Rank, MatchedCount>) {
    fun count(rank: Rank): Int {
        return values[rank] ?: 0
    }

    fun rate(amount: Amount): BigDecimal {
        val totalPrize =
            values.map {
                it.key.prize(it.value)
            }.sumOf {
                it.value
            }

        return totalPrize.divide(amount.value, 2, RoundingMode.DOWN)
    }

    companion object {
        fun fromGroupBy(counts: List<Rank>): Ranks {
            return Ranks(counts.groupingBy { it }.eachCount())
        }
    }
}
