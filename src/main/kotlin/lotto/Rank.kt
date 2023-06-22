package lotto

enum class Rank(val matchCount: Int, val matchBonus: Boolean, val reward: Long) {
    FIRST(6, false, 2_000_000_000),
    SECOND_WITH_BONUS(5, true, 30_000_000),
    SECOND(5, false, 1_500_000),
    THIRD(4, false, 50_000),
    FOURTH(3, false, 5_000)
    ;

    companion object {
        fun of(matchCount: Int, matchBonus: Boolean): Rank? {
            val matchingAll = values().find { it.matchCount == matchCount && it.matchBonus == matchBonus }
            if (matchingAll != null) {
                return matchingAll
            }
            val matchingCount = values().find { it.matchCount == matchCount }
            if (matchingCount != null) {
                return matchingCount
            }
            return null
        }
    }
}
