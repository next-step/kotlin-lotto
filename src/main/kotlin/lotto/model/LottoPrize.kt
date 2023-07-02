package lotto.model

enum class LottoPrize(val matchingCount: Int, val bonusMatching: Int = 0, val prizeAmount: Long) {
    FIRST(6, 0, 2000000000),
    BONUS(5, 1, 30000000),
    SECOND(5, 0, 1500000),
    THIRD(4, 0, 50000),
    FOURTH(3, 0, 5000),
    NONE_PRIZE(0, 0, 0);

    companion object {
        private const val PRIZING_CONT = 3
        private const val SECOND_PRIZE_MATCHING_COUNT = 5
        fun getLottoPrize(matchingCount: Int, lastWeekBonusNumber: Int): LottoPrize {
            if (matchingCount < PRIZING_CONT) {
                return NONE_PRIZE
            }

            val prize = values().find { it.matchingCount == matchingCount } ?: return NONE_PRIZE

            if (matchingCount == SECOND_PRIZE_MATCHING_COUNT) {
                if ( lastWeekBonusNumber > 0)  return BONUS
                else return SECOND
            }
            return prize
        }
    }
}
