package lotto.domain

enum class Winner(val matchingCount: Int, val prize: Int) {
    FIRST_GRADE(SIX_MATCHING_COUNT, FIRST_WIN_PRIZE),
    SECOND_GRADE(FIVE_MATCHING_COUNT, SECOND_WIN_PRIZE),
    THIRD_GRADE(FIVE_MATCHING_COUNT, THIRD_WIN_PRIZE),
    FOURTH_GRADE(FOUR_MATCHING_COUNT, FOURTH_WIN_PRIZE),
    FIVE_GRADE(THREE_MATCHING_COUNT, FIFTH_WIN_PRIZE),
    NO_MATCH(ZERO_MATCHING_COUNT, NONE_WIN_PRIZE);

    companion object {

        fun safeValueOf(matchingCount: Int): Winner {
            return Winner.values().find { it.matchingCount == matchingCount } ?: NO_MATCH
        }
    }
}
