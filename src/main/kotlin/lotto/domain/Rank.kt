package lotto.domain

enum class Rank(val numOfMatch: Int, val winningMoney: Long) {
    FIFTH(3, 5_000L),
    FOURTH(4, 50_000L),
    THIRD(5, 1_500_000L),
    SECOND(5, 30_000_000L),
    FIRST(6, 2_000_000_000L),
    MISS(0, 0);

    companion object {
        fun of(numOfMatch: Int, matchBonus: Boolean): Rank {
            return if (numOfMatch == 5 && matchBonus) {
                SECOND
            } else if (numOfMatch == 5) {
                THIRD
            } else {
                values().find { it.numOfMatch == numOfMatch } ?: MISS
            }
        }
    }
}
