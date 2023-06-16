package lotto.domain

enum class Rank(val countOfMatch: Int, val winningMoney: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISSING(0, 0);

    companion object {
        fun valueOf(countOfMatch: Int, isBonusMatched: Boolean): Rank {
            return values().find {
                if (countOfMatch == 5) {
                    it.winningMoney == getMatchFiveMoney(isBonusMatched)
                } else {
                    it.countOfMatch == countOfMatch
                }
            } ?: MISSING
        }

        private fun getMatchFiveMoney(isBonusMatched: Boolean): Int {
            return if (isBonusMatched) {
                SECOND.winningMoney
            } else {
                THIRD.winningMoney
            }
        }
    }
}
