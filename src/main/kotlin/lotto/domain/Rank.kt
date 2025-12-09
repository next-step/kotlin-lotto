package lotto.domain

enum class Rank(val countOfMatch: Int, val winningMoney: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0),
    ;

    companion object {
        fun valueOf(
            countOfMatch: Int,
            hasBonus: Boolean = false,
        ): Rank {
            return when {
                countOfMatch == 6 -> FIRST
                countOfMatch == 5 && hasBonus -> SECOND
                countOfMatch == 5 -> THIRD
                countOfMatch == 4 -> FOURTH
                countOfMatch == 3 -> FIFTH
                else -> MISS
            }
        }
    }
}
