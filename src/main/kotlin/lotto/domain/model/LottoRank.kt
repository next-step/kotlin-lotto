package lotto.domain.model

enum class LottoRank(
    val numberOfMatches: NumberOfMatches,
    val needToMatchBonusBall: Boolean,
    val winnings: Int
) {
    NOTHING(NumberOfMatches(0), false, 0),
    FIFTH(NumberOfMatches(3), false, 5_000),
    FOURTH(NumberOfMatches(4), false, 50_000),
    THIRD(NumberOfMatches(5), false, 1_500_000),
    SECOND(NumberOfMatches(5), true, 1_500_000),
    FIRST(NumberOfMatches(6), false, 2_000_000_000);

    fun isWin(): Boolean = this != NOTHING

    companion object {
        fun of(numberOfMatches: NumberOfMatches, isBonusBallMatched: Boolean): LottoRank {
            return values().findLast { lottoRank ->
                lottoRank.numberOfMatches == numberOfMatches && (!lottoRank.needToMatchBonusBall || isBonusBallMatched)
            } ?: NOTHING
        }

        fun winnerPlace(): List<LottoRank> = values().filterNot { it == NOTHING }
    }
}
