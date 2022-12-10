package step2.lotto.domain

enum class MatchResult {
    FIRST_PLACE,
    SECOND_PLACE,
    THIRD_PLACE,
    FOURTH_PLACE,
    NOT_WINNING;

    companion object {
        fun valueOf(matchCount: Int): MatchResult {
            return when (matchCount) {
                6 -> FIRST_PLACE
                5 -> SECOND_PLACE
                4 -> THIRD_PLACE
                3 -> FOURTH_PLACE
                else -> NOT_WINNING
            }
        }
    }
}
