package lotto

enum class LottoPrize(
    val reward: Int,
    val matchPrize: (matchCount: Int, bonusMatch: Boolean) -> Boolean
) {
    FIRST_PLACE(2_000_000_000, { matchCount, bonusMatch -> matchCount == 6 }),
    SECOND_PLACE(30_000_000, { matchCount, bonusMatch -> (matchCount == 5) && bonusMatch }),
    THIRD_PLACE(1_500_000, { matchCount, bonusMatch -> (matchCount == 5) && !bonusMatch }),
    FORTH_PLACE(50_000, { matchCount, bonusMatch -> matchCount == 4 }),
    FIFTH_PLACE(5_000, { matchCount, bonusMatch -> matchCount == 3 }),
    MISS_PLACE(0, { matchCount, bonusMatch -> matchCount == 0 });

    companion object {
        fun of(matchResult: LottoMatchResult): LottoPrize {
            return values().find { it.matchPrize(matchResult.matchCount, matchResult.isBonusMatch) } ?: MISS_PLACE
        }
    }
}
