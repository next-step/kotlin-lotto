package lotto.domain

enum class PrizeResult(val matchCount: Int, val prize: Int, val hasBonus: Boolean) {

    FIFTH(3, 5_000, false),
    FORTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false),
    MISS(0, 0, false);

    companion object {
        fun findByMatch(matchedCount: Int, isBonusNumberMatched: Boolean): PrizeResult {
            if (matchedCount == THIRD.matchCount) return when (isBonusNumberMatched) {
                true -> SECOND
                false -> THIRD
            }
            return values().find { it.matchCount == matchedCount } ?: MISS
        }
    }
}
