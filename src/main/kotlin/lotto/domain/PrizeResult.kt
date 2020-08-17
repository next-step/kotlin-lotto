package lotto.domain

enum class PrizeResult(val matchCount: Int, val prize: Int) {

    FIFTH(3, 5_000),
    FORTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND_WITH_BONUS(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    MISS(0, 0);

    companion object {

        fun findByMatch(matchedCount: Int, isBonusNumberMatched: Boolean): PrizeResult {
            if (matchedCount == THIRD.matchCount) return when (isBonusNumberMatched) {
                true -> SECOND_WITH_BONUS
                false -> THIRD
            }
            return values().find { it.matchCount == matchedCount } ?: MISS
        }

        fun winningPrize() = values().sumBy { it.prize * (result[it] ?: 0) }
    }
}

var result = mutableMapOf<PrizeResult, Int>()
