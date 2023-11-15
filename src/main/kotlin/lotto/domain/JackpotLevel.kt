package lotto.domain

enum class JackpotLevel(val matchCount: Int, val price: Int, val matchBonus: Boolean) {
    NO_MATCH(0, 0, false),
    ONE_MATCH(1, 0, false),
    TWO_MATCH(2, 0, false),
    THREE_MATCH(3, 5_000, false),
    FOUR_MATCH(4, 50_000, false),
    FIVE_MATCH(5, 1_500_000, false),
    FIVE_MATCH_BONUS(5, 30_000_000, true),
    SIX_MATCH(6, 2_000_000_000, false),
    ;

    companion object {
        fun findMatchingLevel(matchNumberCount: Int, matchBonus: Boolean): JackpotLevel {
            return values().firstOrNull {
                when (it) {
                    FIVE_MATCH, FIVE_MATCH_BONUS -> it.matchCount == matchNumberCount && it.matchBonus == matchBonus
                    else -> it.matchCount == matchNumberCount
                }
            } ?: NO_MATCH
        }
    }

    fun filterMatchingLevel(level: Int) = matchCount >= level
}
