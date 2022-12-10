package step2.lotto.domain

enum class MatchResult(val matchCount: Int, val reward: Int) {
    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 1_500_000),
    THIRD_PLACE(4, 50_000),
    FOURTH_PLACE(3, 5_000),
    NOT_WINNING(0, 0);

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
