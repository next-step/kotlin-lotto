package lottery.domain

enum class Rank(val countOfMatch: Int, val winningMoney: Int) {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    MISS(0, 0);

    companion object {
        fun of(countOfMatch: Int, matchBonus: Boolean = false): Rank {
            return if (countOfMatch == 5) {
                if (matchBonus) SECOND else THIRD
            } else values().find {
                it.countOfMatch == countOfMatch
            } ?: MISS
        }

        fun getWinningRanks() = (Rank.values().toList() - MISS)
    }
}
