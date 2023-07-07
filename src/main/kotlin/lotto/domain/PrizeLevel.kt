package lotto.domain

import lotto.dto.MatchedCount

enum class PrizeLevel(val numberOfHit: Int, val prizeMoney: Int, hasBonus: Boolean = false) {
    NONE(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000);

    companion object {
        fun proceedLevel(matchedCount: MatchedCount): PrizeLevel {
            val (numberOfHit, isBonusNumberMatch) = matchedCount
            return values().firstOrNull { it.matches(numberOfHit, isBonusNumberMatch) } ?: NONE
        }

        private fun PrizeLevel.matches(numberOfHit: Int, isBonusNumberMatch: Boolean): Boolean {
            if (this == SECOND) {
                return this.numberOfHit == numberOfHit && isBonusNumberMatch
            }
            if (this == THIRD) {
                return this.numberOfHit == numberOfHit && !isBonusNumberMatch
            }
            return this.numberOfHit == numberOfHit
        }
    }
}
