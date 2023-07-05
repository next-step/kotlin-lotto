package lotto.domain

enum class Rank(val countOfMatch: Int, val winningMoney: Long) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0),
    ;

    operator fun times(count: Int): Long = winningMoney * count

    companion object {
        fun of(countOfMatch: Int, matchBonus: Boolean): Rank {
            if (countOfMatch == SECOND.countOfMatch && matchBonus) return SECOND

            values().find { it.countOfMatch == countOfMatch && it != SECOND }?.let { return it }
            return MISS
        }
    }
}
