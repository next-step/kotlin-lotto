package lotto.model

enum class LottoPrize(
    val matchedCount: Int,
    val prize: Int
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    companion object {
        fun of(matchedCount: Int, isBonusNumberMatched: Boolean): LottoPrize {
            if (matchedCount != MATCHED_NUMBER_COUNT_FIVE)
                return values().find { it.matchedCount == matchedCount } ?: MISS

            return if (isBonusNumberMatched) { SECOND } else { THIRD }
        }

        private const val MATCHED_NUMBER_COUNT_FIVE = 5
    }
}
