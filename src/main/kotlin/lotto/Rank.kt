package lotto

import java.lang.IllegalArgumentException

enum class Rank(private val matchCount: Int) {
    FIRST(6),
    SECOND(5),
    THIRD(5),
    FORTH(4),
    FIFTH(3),
    MISS(0);

    companion object {
        fun rank(matchCount: Int, matchBonus: Boolean): Rank {
            if (matchCount != SECOND.matchCount) {
                return values().find { matchCount == it.matchCount } ?: MISS
            }

            return if (matchBonus) {
                SECOND
            } else {
                THIRD
            }
        }
    }
}
