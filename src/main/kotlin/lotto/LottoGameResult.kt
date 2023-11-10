package lotto

data class LottoGameResult(val totalPrice: Int, val rewards: List<LottoReward>) {
    fun calculatePerformance(): Double =
        rewards.getAmount().toDouble() / totalPrice

    fun getRewardCount(reward: LottoReward): Int =
        rewards.count { it == reward }
}
