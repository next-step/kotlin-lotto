package lotto.domain.model

enum class LottoRank(
    val numberOfMatches: NumberOfMatches,
    val winnings: Int
) {
    NOTHING(NumberOfMatches(0), 0),
    FOURTH(NumberOfMatches(3), 5_000),
    THIRD(NumberOfMatches(4), 50_000),
    SECOND(NumberOfMatches(5), 1_500_000),
    FIRST(NumberOfMatches(6), 2_000_000_000);

    companion object {
        fun from(numberOfMatches: NumberOfMatches): LottoRank {
            return values().find { lottoRank ->
                lottoRank.numberOfMatches == numberOfMatches
            } ?: NOTHING
        }
    }
}
