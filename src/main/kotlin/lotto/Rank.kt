package lotto

import java.math.BigDecimal

enum class Rank(val matchCount: Int, val prize: Amount, val isBonus: Boolean = false) {
    FIRST(6, Amount(BigDecimal(2_000_000_000))),
    SECOND(5, Amount(BigDecimal(30_000_000)), true),
    THIRD(5, Amount(BigDecimal(1_500_000))),
    FOURTH(4, Amount(BigDecimal(50_000))),
    FIFTH(3, Amount(BigDecimal(5_000))),
    MISS(0, Amount(BigDecimal(0))),
    ;

    fun prize(value: MatchedCount): Amount {
        return prize.times(value)
    }

    companion object {
        private val noBonusRanks: List<Rank> =
            entries.filter { it != MISS && it != SECOND }
                .sortedBy { it.matchCount }
        val prizeRanks: List<Rank> =
            entries.filter { it != MISS }
                .sortedBy { it.matchCount }

        fun match(
            matchCount: Int,
            isBonus: Boolean,
        ): Rank {
            if (SECOND.sameMatchCount(matchCount) && isBonus) {
                return SECOND
            }

            return noBonusRanks.find { it.matchCount == matchCount } ?: MISS
        }
    }

    private fun sameMatchCount(matchCount: Int): Boolean {
        return this.matchCount == matchCount
    }
}
