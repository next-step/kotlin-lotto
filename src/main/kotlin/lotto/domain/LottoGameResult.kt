package lotto.domain

data class LottoGameResult(val totalPrice: Int, val rewards: List<LottoReward>) {
    fun calculatePerformance(): Double =
        getRewardAmount().toDouble() / totalPrice

    fun getRewardCount(reward: LottoReward): Int =
        rewards.count { it == reward }

    private fun getRewardAmount(): Int =
        rewards.sumOf { it.reward }
}
