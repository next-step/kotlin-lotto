package lotto.sixFortyFiveNumberLotto

enum class SixFortyFiveWinningEnum(val countOfMatch: Int, val bonusNumber: Boolean, val price: Int) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0),
    ;

    companion object {
        fun valueOf(sixFortyFiveLottoWinningResult: SixFortyFiveLottoWinningResult): SixFortyFiveWinningEnum {
            if (sixFortyFiveLottoWinningResult.countOfMatch == SECOND.countOfMatch && sixFortyFiveLottoWinningResult.isMatchedBonus) return SECOND
            return values().filter { it != SECOND }
                .find { it.countOfMatch == sixFortyFiveLottoWinningResult.countOfMatch } ?: MISS
        }
    }
}
