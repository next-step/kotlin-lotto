package lotto

enum class Rank(val matchedCount: Int, val reward: Long) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FORTH(3, 5_000),
    LOSE(0, 0);

    companion object {
        private const val MIN_MATCHED_COUNT = 3
        const val INVALID_MATCHED_COUNT_MESSAGE = "비정상적인 matchedCount입니다. %d"

        fun from(matchedCount: Int): Rank {
            if (matchedCount < MIN_MATCHED_COUNT) {
                return LOSE
            }

            return values().find { it.matchedCount == matchedCount } ?: throw IllegalArgumentException(INVALID_MATCHED_COUNT_MESSAGE.format(matchedCount))
        }
    }
}
