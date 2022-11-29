package lotto.domain

enum class LottoRank(val countOfMatch: Int, val winningMoney: Int) {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    companion object {
        fun valueOf(countOfMatch: Int): LottoRank {
            return values().find { it.countOfMatch == countOfMatch } ?: MISS
        }
    }
}
