package lotto.domain

enum class Rank(val countOfMatch: Int, val winningMoney: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISSING(0, 0);

    companion object {
        private const val MATCH_FIVE = 5

        fun valueOf(countOfMatch: Int, isBonusMatched: Boolean): Rank {
            return if (countOfMatch == MATCH_FIVE) {
                getMatchFiveMoney(isBonusMatched)
            } else {
                values().firstOrNull { it.countOfMatch == countOfMatch } ?: MISSING
            }
        }

        private fun getMatchFiveMoney(isBonusMatched: Boolean): Rank {
            return if (isBonusMatched) {
                SECOND
            } else {
                THIRD
            }
        }
    }
}
