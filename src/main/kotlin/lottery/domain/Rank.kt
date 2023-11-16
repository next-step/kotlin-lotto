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
            return values().firstOrNull { it.isMatchingRank(countOfMatch, matchBonus) } ?: MISS
        }

        fun getWinningRanks() = (Rank.values().toList() - MISS)

        private fun Rank.isMatchingRank(countOfMatch: Int, matchBonus: Boolean): Boolean {
            if (this == SECOND && countOfMatch == 5) return matchBonus
            if (this == THIRD && countOfMatch == 5) return !matchBonus
            return this.countOfMatch == countOfMatch
        }
    }
}
