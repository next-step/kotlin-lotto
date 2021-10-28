package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

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
        val totalAmount = getTotalAmount().toBigDecimal()
        val budgetAmount = budget.value.toBigDecimal()
        return totalAmount.divide(budgetAmount, 2, RoundingMode.DOWN)
    }

    private fun getTotal(reward: Reward): Int {
        return result[reward]?.times(reward.amount) ?: 0
    }

    companion object {
        val EMPTY = LottoResult(emptyMap())
    }
}
