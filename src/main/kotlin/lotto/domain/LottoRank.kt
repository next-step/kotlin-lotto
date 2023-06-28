package lotto.domain

enum class LottoRank(val prizeMoney: Int) {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000),
    LOSE(0);

    companion object {
        fun getRank(matchCount: Int, isBonusMatch: Boolean): LottoRank {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && isBonusMatch -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> LOSE
            }
        }
    }
}
