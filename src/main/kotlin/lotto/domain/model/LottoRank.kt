package lotto.domain.model

enum class LottoRank(
    val numberOfMatches: NumberOfMatches,
    val winnings: Int
) {
    NOTHING(NumberOfMatches(0), 0),
    FIFTH(NumberOfMatches(3), 5_000),
    FOURTH(NumberOfMatches(4), 50_000),
    THIRD(NumberOfMatches(5), 1_500_000),
    SECOND(NumberOfMatches(5), 30_000_000),
    FIRST(NumberOfMatches(6), 2_000_000_000);

    fun isWin(): Boolean = this != NOTHING

    companion object {
        fun of(numberOfMatches: NumberOfMatches, isBonusBallMatched: Boolean): LottoRank {
            return values().findLast { lottoRank ->
                lottoRank.numberOfMatches == numberOfMatches && (lottoRank != SECOND || isBonusBallMatched)
            } ?: NOTHING
        }

        fun winnerPlace(): List<LottoRank> = values().filterNot { it == NOTHING }
    }
}
