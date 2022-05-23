package lotto.agency

enum class LottoWinning(val matchCount: Int, val winningMoney: Int) {

    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 1_500_000),
    THIRD_PLACE(4, 50_000),
    FOURTH_PLACE(3, 5_000),
    LOSE(0, 0);

    companion object {
        fun of(matchCount: Int): LottoWinning {
            return values().find {
                it.matchCount == matchCount
            } ?: LOSE
        }
    }
}
