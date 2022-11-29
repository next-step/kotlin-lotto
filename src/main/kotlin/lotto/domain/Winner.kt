package lotto.domain

enum class Winner(val matchingCount: Int, val prize: Int) {
    FIRST_GRADE(FIRST_GRADE_MATCHING_COUNT, FIRST_WIN_PRIZE),
    SECOND_GRADE(SECOND_GRADE_MATCHING_COUNT, SECOND_WIN_PRIZE),
    THIRD_GRADE(THIRD_GRADE_MATCHING_COUNT, THIRD_WIN_PRIZE),
    FOURTH_GRADE(FOURTH_GRADE_MATCHING_COUNT, FOURTH_WIN_PRIZE),
    FIVE_GRADE(FIFTH_GRADE_MATCHING_COUNT, NONE_WIN_PRIZE),
    SIX_GRADE(SIXTH_GRADE_MATCHING_COUNT, NONE_WIN_PRIZE),
    NO_MATCH(NONE_GRADE_MATCHING_COUNT, NONE_WIN_PRIZE);

    companion object {

        fun safeValueOf(matchingCount: Int): Winner {
            return Winner.values().find { it.matchingCount == matchingCount } ?: NO_MATCH
        }
    }
}
