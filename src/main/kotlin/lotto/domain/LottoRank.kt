package lotto.domain

enum class LottoRank(val displayName: String, val countOfMatch: Int, val winningMoney: Int) {
    FIRST("1등", 6, 2_000_000_000),
    SECOND("2등", 5, 30_000_000),
    THIRD("3등", 5, 1_500_000),
    FOURTH("4등", 4, 50_000),
    FIFTH("5등", 3, 5_000),
    MISS("낙첨", 0, 0);

    companion object {
        fun valueOf(countOfMatch: Int): LottoRank {
            return values().find {
                it.countOfMatch == countOfMatch
            } ?: MISS
        }

        fun getMinCountOfMatchForWin(): Int {
            return values()
                .filter { it != MISS && it.countOfMatch > 0 }
                .minByOrNull { it.countOfMatch }
                ?.countOfMatch ?: 0
        }
    }
}
