package lotto.domain

enum class LottoRank(val displayName: String, val countOfMatch: Int, val winningMoney: Int) {
    FIRST("1등", 6, 2_000_000_000),
    SECOND("2등", 5, 30_000_000),
    THIRD("3등", 5, 1_500_000),
    FOURTH("4등", 4, 50_000),
    FIFTH("5등", 3, 5_000),
    MISS_WITH_TWO_MATCH("낙첨", 2, 0),
    MISS_WITH_ONE_MATCH("낙첨", 1, 0),
    MISS_WITH_ZERO_MATCH("낙첨", 0, 0);

    companion object {
        fun valueOf(countOfMatch: Int, isBonusNumberInLotto: Boolean): LottoRank? {
            return when {
                countOfMatch == SECOND.countOfMatch && isBonusNumberInLotto -> SECOND
                countOfMatch == THIRD.countOfMatch && !isBonusNumberInLotto -> THIRD
                else -> values().find { it.countOfMatch == countOfMatch }
            }
        }

        fun getMinCountOfMatchForWin(): Int {
            return values()
                .filter { it.winningMoney > 0 }
                .minByOrNull { it.countOfMatch }
                ?.countOfMatch ?: 0
        }
    }
}
