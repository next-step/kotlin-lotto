package lotto

enum class Rank(val count: Int, val prize: Int) {
    NONE(0, 0),
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    companion object {
        private const val MIN_MATCH_COUNT = 3

        fun of(matchCount: Int, matchBonus: Boolean): Rank {
            return when {
                matchCount < MIN_MATCH_COUNT -> NONE
                matchBonus && matchCount == SECOND.count -> SECOND
                else -> Rank.values().filter { it.count == matchCount }[0]
            }
        }
    }
}
