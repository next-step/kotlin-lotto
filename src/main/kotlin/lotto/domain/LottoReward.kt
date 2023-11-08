package lotto.domain

object LottoReward {
    private const val REWARD_MATCH_3 = LottoConstants.PRIZE_MATCH_3
    private const val REWARD_MATCH_4 = LottoConstants.PRIZE_MATCH_4
    private const val REWARD_MATCH_5 = LottoConstants.PRIZE_MATCH_5
    private const val REWARD_MATCH_5_BONUS = LottoConstants.PRIZE_MATCH_5_BONUS
    private const val REWARD_MATCH_6 = LottoConstants.PRIZE_MATCH_6

    fun getRewardByMatchCount(matchCount: Int, bonus: Boolean = false): Int {
        return when {
            matchCount == 5 && bonus -> REWARD_MATCH_5_BONUS
            matchCount == 5 -> REWARD_MATCH_5
            matchCount == 4 -> REWARD_MATCH_4
            matchCount == 3 -> REWARD_MATCH_3
            matchCount == 6 -> REWARD_MATCH_6
            else -> 0
        }
    }
}
