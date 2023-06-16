package lotto.domain

enum class Rank(val countOfMatch: Int, val winningMoney: Int) {
    SIX(6, 2_000_000_000),
    FIVE(5, 1_500_000),
    FOUR(4, 50_000),
    THREE(3, 5_000),
    MISSING(0, 0);

    companion object {
        fun valueOf(countOfMatch: Int): Rank {
            return values().firstOrNull { it.countOfMatch == countOfMatch } ?: MISSING
        }
    }
}
