package lotto.domain

enum class LottoRank(val countOfMatch: Int, val winningMoney: Int) {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    companion object {
        fun valueOf(countOfMatch: Int, matchBonus: Boolean): LottoRank {
            if (countOfMatch == SECOND.countOfMatch && matchBonus) {
                return SECOND
            }
            return values().find { it.countOfMatch == countOfMatch } ?: MISS
        }
    }
}
