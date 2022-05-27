package lotto.agency

enum class LottoWinning(val matchCount: Int, val winningMoney: Int) {

    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 30_000_000),
    THIRD_PLACE(5, 1_500_000),
    FOURTH_PLACE(4, 50_000),
    FIFTH_PLACE(3, 5_000),
    LOSE(0, 0);

    companion object {
        private const val SECOND_OR_THIRD_PLACE_DECIDE = 5

        fun of(matchCount: Int, isMatchedBonus: Boolean): LottoWinning {
            return values().find {
                if (matchCount == SECOND_OR_THIRD_PLACE_DECIDE) {
                    return decideSecondOrThirdPlace(isMatchedBonus)
                } else {
                    it.matchCount == matchCount
                }
            } ?: LOSE
        }

        private fun decideSecondOrThirdPlace(isMatchedBonus: Boolean): LottoWinning {
            return if (isMatchedBonus) {
                SECOND_PLACE
            } else {
                THIRD_PLACE
            }
        }
    }
}
