package model

enum class Rank(val grade: Int, val prizeMoney: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    fun sumPrizeMoney(count: Int): Int {
        return prizeMoney * count
    }

    companion object {
        fun valueOf(countOfMatch: Int, matchBonus: Boolean): Rank {
            return values().find { getRank(countOfMatch, matchBonus, it) } ?: MISS
        }

        private fun getRank(countOfMatch: Int, matchBonus: Boolean, it: Rank): Boolean {
            return if (countOfMatch == SECOND.grade && matchBonus) {
                it == SECOND
            } else if (countOfMatch == THIRD.grade && !matchBonus) {
                it == THIRD
            } else {
                it.grade == countOfMatch
            }
        }
    }
}
