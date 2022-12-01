package lotto.domain

enum class Winner(val matchingCount: Int, val prize: Int, val bonus: Boolean) {
    FIRST_GRADE(SIX_MATCHING_COUNT, FIRST_WIN_PRIZE, false),
    SECOND_GRADE(FIVE_MATCHING_COUNT, SECOND_WIN_PRIZE, true),
    THIRD_GRADE(FIVE_MATCHING_COUNT, THIRD_WIN_PRIZE, false),
    FOURTH_GRADE(FOUR_MATCHING_COUNT, FOURTH_WIN_PRIZE, false),
    FIVE_GRADE(THREE_MATCHING_COUNT, FIFTH_WIN_PRIZE, false),
    NO_MATCH(ZERO_MATCHING_COUNT, NONE_WIN_PRIZE, false);

    companion object {

        fun safeValueOf(matchingCount: Int, bonus: Boolean): Winner {
            return Winner.values().find {
                it.matchingCount == matchingCount && it.bonus == bonus
            } ?: NO_MATCH
        }
    }
}
