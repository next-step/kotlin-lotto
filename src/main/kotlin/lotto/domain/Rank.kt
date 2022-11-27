package lotto.domain

enum class Rank(val numberOfMatch: Int, val winningMoney: Int) {
    FIRST(6, 200_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    fun getTotalWinningMoney(count: Int) = count * winningMoney

    companion object {
        fun valueOf(numberOfMatch: Int, isBonusMatch: Boolean): Rank {
            if (numberOfMatch == SECOND.numberOfMatch && isBonusMatch)
                return SECOND

            return Rank.values()
                .filter { it != SECOND }
                .firstOrNull { it.numberOfMatch == numberOfMatch } ?: MISS
        }
    }
}
