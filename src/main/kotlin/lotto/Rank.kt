package lotto

enum class Rank(val matchedCount: Int) {
    FIRST(6),
    SECOND(5),
    THIRD(4),
    FORTH(3),
    LOSE(0);

    companion object {
        private const val MIN_MATCHED_COUNT = 3
        const val INVALID_MATCHED_COUNT_MESSAGE = "비정상적인 matchedCount입니다."

        fun from(matchedCount: Int): Rank {
            if (matchedCount < MIN_MATCHED_COUNT) {
                return LOSE
            }

            return values().find { it.matchedCount == matchedCount } ?: throw IllegalArgumentException(INVALID_MATCHED_COUNT_MESSAGE)
        }
    }
}
