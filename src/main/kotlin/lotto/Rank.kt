package lotto

import java.lang.IllegalArgumentException

enum class Rank(private val matchCount: Int, private val prize: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FORTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    fun prizeByCount(count: Int): Int = count * prize

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
