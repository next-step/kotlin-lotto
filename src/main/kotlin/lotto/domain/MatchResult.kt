package lotto.domain

enum class MatchResult(val matchCount: Int, val reward: Int) : Comparable<MatchResult> {
    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 30_000_000),
    THIRD_PLACE(5, 1_500_000),
    FOURTH_PLACE(4, 50_000),
    FIFTH_PLACE(3, 5_000),
    NOT_WINNING(0, 0);

    fun isSecondPlace(): Boolean = this == SECOND_PLACE
    fun isNotNoting(): Boolean = this != NOT_WINNING

    companion object {
        private val MATCH_COUNT_RANGE = NOT_WINNING.matchCount..FIRST_PLACE.matchCount
        private const val NOT_FOUND_MATCH_RESULT_ERROR_MESSAGE = "[%d]개에 일치하는 당첨 등수를 찾을 수 없습니다."
        private val values: Map<Int, MatchResult> = MatchResult.values()
            .mapIndexed { _, matchResult -> matchResult.matchCount to matchResult }
            .toMap()

        fun valueOf(matchCount: Int, containsBonusNumber: Boolean): MatchResult {
            validateMatchCount(matchCount)
            if (matchCount == SECOND_PLACE.matchCount) {
                return decideSecondPlace(containsBonusNumber)
            }
            return values[matchCount] ?: NOT_WINNING
        }

        private fun decideSecondPlace(containsBonusNumber: Boolean): MatchResult {
            if (containsBonusNumber) {
                return SECOND_PLACE
            }
            return THIRD_PLACE
        }

        private fun validateMatchCount(matchCount: Int) =
            require(MATCH_COUNT_RANGE.contains(matchCount)) {
                NOT_FOUND_MATCH_RESULT_ERROR_MESSAGE.format(matchCount)
            }
    }
}
