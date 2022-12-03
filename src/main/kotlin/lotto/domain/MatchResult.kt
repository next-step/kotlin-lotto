package lotto.domain

enum class MatchResult(
    val matchCount: Int,
    val isBonusBallMatched: Boolean,
    val amount: Int,
) {
    NON_MATCH(0, false, 0),
    ONE_MATCH(1, false, 0),
    TWO_MATCH(2, false, 0),
    THREE_MATCH(3, false, 5000),
    FOUR_MATCH(4, false, 50000),
    FIVE_MATCH(5, false, 1500000),
    FIVE_MATCH_WITH_BONUS_BALL(5, true, 30000000),
    SIX_MATCH(6, false, 2000000000);

    fun checkBonusBall(isBonusBallMatched: Boolean): Boolean {
        if (this == FIVE_MATCH_WITH_BONUS_BALL) {
            return isBonusBallMatched
        }
        return true
    }

    companion object {
        private const val WINNER_MINIMUM_THRESH_HOLD = 3
        private const val SECOND_RANK_MATCH_COUNT = 5

        fun of(matchCount: Int, isBonusBallMatched: Boolean): MatchResult {
            if (matchCount == SECOND_RANK_MATCH_COUNT && isBonusBallMatched) {
                return FIVE_MATCH_WITH_BONUS_BALL
            }
            return values().first { it.matchCount == matchCount }
        }

        fun winner(): List<MatchResult> {
            return values().filter { it.matchCount >= WINNER_MINIMUM_THRESH_HOLD }
        }
    }
}
