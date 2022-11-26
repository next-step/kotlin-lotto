package lotto.domain

enum class LottoRank(val countOfMatch: Int, val winningMoney: Int) {
    FIRST(6, 2_000_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    companion object {
        fun valueOf(countOfMatch: Int): LottoRank {
            return values().find { it.countOfMatch == countOfMatch } ?: MISS
        }
    }
}
