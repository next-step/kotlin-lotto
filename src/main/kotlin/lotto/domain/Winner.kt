package lotto.domain

enum class Winner(val matchingCount: Int, val prize: Int, private val calculateReward: (Int, Int) -> Int) {
    FIRST_GRADE(FIRST_GRADE_MATCHING_COUNT, FIRST_WIN_PRIZE, { a, b -> a * b }),
    SECOND_GRADE(SECOND_GRADE_MATCHING_COUNT, SECOND_WIN_PRIZE, { a, b -> a * b }),
    THIRD_GRADE(THIRD_GRADE_MATCHING_COUNT, THIRD_WIN_PRIZE, { a, b -> a * b }),
    FOURTH_GRADE(FOURTH_GRADE_MATCHING_COUNT, FOURTH_WIN_PRIZE, { a, b -> a * b }),
    FIVE_GRADE(FIFTH_GRADE_MATCHING_COUNT, NONE_WIN_PRIZE, { a, b -> a * b }),
    SIX_GRADE(SIXTH_GRADE_MATCHING_COUNT, NONE_WIN_PRIZE, { a, b -> a * b }),
    NO_MATCH(NONE_GRADE_MATCHING_COUNT, NONE_WIN_PRIZE, { a, b -> a * b });

    fun calculate(numberOfMatchingLotto: Int): Int = calculateReward(prize, numberOfMatchingLotto)

    companion object {

        fun safeValueOf(matchingCount: Int): Winner {
            return Winner.values().find { it.matchingCount == matchingCount } ?: NO_MATCH
        }
    }
}