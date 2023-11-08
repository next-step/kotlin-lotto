package lotto.enum

enum class Rank(val countOfMatch: Int, val winningMoney: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    companion object {
        fun valueOf(countOfMatch: Int, matchBonus: Boolean): Rank {
            return values().find { rank ->
                when (rank) {
                    SECOND -> countOfMatch == 5 && matchBonus
                    THIRD -> countOfMatch == 5 && !matchBonus
                    else -> countOfMatch == rank.countOfMatch
                }
            } ?: MISS
        }
    }
}
