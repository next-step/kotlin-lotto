package lotto

import java.util.EnumMap

class BoughtLotto(
    private val lottos: List<Lotto>,
    private val winningLotto: WinningLotto,
) {
    fun matchResult(): LottoResult {
        val initialRewards = initializeRewards()
        val rewards = lottos
            .map { winningLotto.match(it) }
            .groupingBy { it }
            .eachCount()
        return LottoResult(initialRewards + rewards)
    }

    private fun initializeRewards(): EnumMap<Reward, Int> {
        val initialRewards = EnumMap<Reward, Int>(Reward::class.java)
        Reward.entries
            .forEach { initialRewards[it] = 0 }
        return initialRewards
    }
}

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
