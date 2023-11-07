package lotto.domain

enum class Rank(val countOfMatch: Int, val isMatchBonus: Boolean, val winningMoney: Int) {
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000),
    MISS(0, false, 0);

    companion object {
        fun valueOf(countOfMatch: Int, matchBonus: Boolean): Rank = when (countOfMatch) {
            6 -> FIRST
            5 -> if (matchBonus) SECOND else THIRD
            4 -> FOURTH
            3 -> FIFTH
            else -> MISS
        }
    }
}
