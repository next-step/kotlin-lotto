package lotto

import java.math.BigDecimal

enum class Rank(val matchCount: Int, val prize: Amount, val isBonus: Boolean = false) {
    FIRST(matchCount = 6, prize = Amount(BigDecimal(2_000_000_000))),
    SECOND(matchCount = 5, prize = Amount(BigDecimal(30_000_000)), isBonus = true),
    THIRD(matchCount = 5, prize = Amount(BigDecimal(1_500_000))),
    FOURTH(matchCount = 4, prize = Amount(BigDecimal(50_000))),
    FIFTH(matchCount = 3, prize = Amount(BigDecimal(5_000))),
    MISS(matchCount = 0, prize = Amount(BigDecimal(0))),
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
                .sortedBy { it.prize.value }

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
