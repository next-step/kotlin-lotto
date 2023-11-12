package lotto.domain

enum class JackpotLevel(val matchCount: Int, val price: Int) {
    NO_MATCH(0, 0),
    ONE_MATCH(1, 0),
    TWO_MATCH(2, 0),
    THREE_MATCH(3, 5_000),
    FOUR_MATCH(4, 50_000),
    FIVE_MATCH(5, 1_500_000),
    FIVE_MATCH_BONUS(5, 30_000_000),
    SIX_MATCH(6, 2_000_000_000),
    ;

    companion object {
        fun findMatchingLevel(matchNumberCount: Int): JackpotLevel {
            return values().firstOrNull { it.matchCount == matchNumberCount } ?: NO_MATCH
        }
    }

    fun filterMatchingLevel(level: Int) = matchCount >= level
}
