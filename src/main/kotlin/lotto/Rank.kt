package lotto

import java.math.BigDecimal

enum class Rank(val matchCount: Int, val prize: Amount) {
    FIRST(6, Amount(BigDecimal(2_000_000_000))),
    SECOND(5, Amount(BigDecimal(1_500_000))),
    THIRD(4, Amount(BigDecimal(50_000))),
    FOURTH(3, Amount(BigDecimal(5_000))),
    MISS(0, Amount(BigDecimal(0))),
    ;

    fun prize(value: MatchedCount): Amount {
        return prize.times(value)
    }

    companion object {
        val prizeRanks: List<Rank> =
            entries.filter { it != MISS }
                .sortedBy { it.matchCount }

        fun match(matchCount: Int): Rank {
            return entries.find { it.matchCount == matchCount } ?: MISS
        }
    }
}
