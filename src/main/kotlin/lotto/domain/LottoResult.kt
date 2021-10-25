package lotto.domain

import java.math.RoundingMode
import java.text.DecimalFormat

data class LottoResult(val result: Map<Reward, Int>) {

    fun updateRewards(checked: Map<Reward, Int>): LottoResult {
        var rewardResult = result
        for (match in Reward.values()) {
            val foundValue = Pair(match, checked.getOrDefault(match, 0))
            rewardResult = rewardResult + foundValue
        }
        return LottoResult(rewardResult)
    }

    fun getTotalAmount(): Int {
        return result.keys.map { getTotal(it) }
            .fold(0) { total, amount -> total + amount }
    }

    fun getProfit(budget: Budget): Double {
        return roundOffDecimal(getTotalAmount().toDouble() / budget.value.toDouble())
    }

    private fun getTotal(reward: Reward): Int {
        return result[reward]?.times(reward.amount) ?: 0
    }

    private fun roundOffDecimal(number: Double): Double {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.FLOOR
        return df.format(number).toDouble()
    }

    companion object {
        val EMPTY = LottoResult(emptyMap())
    }
}
