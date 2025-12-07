package lotto

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
            matchBonusBall: Boolean,
        ): Rank {
            if (countOfMatch == 5) {
                return if (matchBonusBall) {
                    SECOND
                } else {
                    THIRD
                }
            }

            return Rank.entries.find {
                it.countOfMatch == countOfMatch
            } ?: MISS
        }
    }
}
