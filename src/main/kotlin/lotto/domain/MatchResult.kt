package lotto.domain

enum class MatchResult(val matchCount: Int, val reward: Int) {
    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 1_500_000),
    THIRD_PLACE(4, 50_000),
    FOURTH_PLACE(3, 5_000),
    NOT_WINNING(0, 0);

    fun isNotNoting(): Boolean = this != NOT_WINNING

    companion object {
        private val MATCH_COUNT_RANGE = NOT_WINNING.matchCount..FIRST_PLACE.matchCount
        private const val NOT_FOUND_MATCH_RESULT_ERROR_MESSAGE = "[%d]개에 일치하는 당첨 등수를 찾을 수 없습니다."
        private val values: Map<Int, MatchResult> = MatchResult.values()
            .mapIndexed { _, matchResult -> matchResult.matchCount to matchResult }
            .toMap()

        fun valueOf(matchCount: Int): MatchResult {
            validateMatchCount(matchCount)
            return values[matchCount] ?: NOT_WINNING
        }

        private fun validateMatchCount(matchCount: Int) =
            require(MATCH_COUNT_RANGE.contains(matchCount)) {
                NOT_FOUND_MATCH_RESULT_ERROR_MESSAGE.format(matchCount)
            }
    }
}
