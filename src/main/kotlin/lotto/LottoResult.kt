package lotto

data class LottoResult(
    private val rewards: Map<Reward, Int>,
) {
    val winningRewards: Map<Reward, Int> = rewards.filter { it.key != Reward.NONE }

    fun calculateRateOfReturn(): Double {
        val totalRewardMoney = rewards.map { it.key.money * it.value }.sum()
        val totalBoughtMoney = rewards.values.sum() * LOTTO_PRICE
        return totalRewardMoney.toDouble() / totalBoughtMoney
    }
}
