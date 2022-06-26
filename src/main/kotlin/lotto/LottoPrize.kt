package lotto

enum class LottoPrize(
    val matchCount: Int,
    val bonusMatch: Boolean,
    val reward: Int,
    val matchPrize: (matchCount: Int, bonusMatch: Boolean) -> Boolean
) {
    FIRST_PLACE(6, false, 2_000_000_000, { matchCount, bonusMatch -> matchCount == 6 }),
    SECOND_PLACE(5, true, 30_000_000, { matchCount, bonusMatch -> (matchCount == 5) && bonusMatch }),
    THIRD_PLACE(5, false, 1_500_000, { matchCount, bonusMatch -> (matchCount == 5) && !bonusMatch }),
    FOURTH_PLACE(4, false, 50_000, { matchCount, bonusMatch -> matchCount == 4 }),
    FIFTH_PLACE(3, false, 5_000, { matchCount, bonusMatch -> matchCount == 3 }),
    MISS_PLACE(0, false, 0, { matchCount, bonusMatch -> matchCount == 0 });

    companion object {
        fun of(matchCount: Int, bonusMatch: Boolean): LottoPrize {
            return values().find { it.matchPrize(matchCount, bonusMatch) } ?: MISS_PLACE
        }
    }
}
