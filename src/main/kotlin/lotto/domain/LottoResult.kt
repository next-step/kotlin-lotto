package lotto.domain

import java.math.BigDecimal

data class LottoResult(val result: Map<Reward, Int>) {

    fun updateRewards(checked: Map<Reward, Int>): LottoResult {
        var rewardResult = result
        Reward.values().forEach { match ->
            val foundValue = Pair(match, checked.getOrDefault(match, 0))
            rewardResult = rewardResult + foundValue
        }
        return LottoResult(rewardResult)
    }

    fun getTotalAmount(): Int {
        return result.keys.map { getTotal(it) }
            .fold(0) { total, amount -> total + amount }
    }

    fun getProfit(budget: Budget): BigDecimal {
        return budget.getProfit(getTotalAmount())
    }

    private fun getTotal(reward: Reward): Int {
        return result[reward]?.times(reward.amount) ?: 0
    }

    companion object {
        val EMPTY = LottoResult(emptyMap())
        private const val NUMBER_FORMAT = 2
    }
}
