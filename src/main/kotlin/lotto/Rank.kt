package lotto

enum class Rank(val matchCount: Int, val prize: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0),
    ;

    companion object {
        fun valueOf(
            countOfMatch: Int,
            matchBonus: Boolean,
        ): Rank {
            return when {
                countOfMatch == SECOND.matchCount && matchBonus -> SECOND
                countOfMatch == THIRD.matchCount && !matchBonus -> THIRD
                else -> entries.find { it.matchCount == countOfMatch } ?: MISS
            }
        }
    }
}
