package lotto.domain

object LottoReward {
    const val REWARD_MATCH_3 = LottoConstants.PRIZE_MATCH_3
    const val REWARD_MATCH_4 = LottoConstants.PRIZE_MATCH_4
    const val REWARD_MATCH_5 = LottoConstants.PRIZE_MATCH_5
    const val REWARD_MATCH_6 = LottoConstants.PRIZE_MATCH_6

    fun getRewardByMatchCount(matchCount: Int): Int {
        return when (matchCount) {
            3 -> REWARD_MATCH_3
            4 -> REWARD_MATCH_4
            5 -> REWARD_MATCH_5
            6 -> REWARD_MATCH_6
            else -> 0
        }
    }
}
