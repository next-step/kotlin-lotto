package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

class RoundResult(private val countPerRank: Map<Rank, Int>) {
    private val rewardPrice = Money(countPerRank.map { it.key.rewardPrice * it.value }.sum())
    private val purchasePrice = Money(countPerRank.map { Policy.LOTTO_PRICE * it.value }.sum())

    fun getCountOfRank(rank: Rank): Int {
        return countPerRank[rank] ?: 0
    }

    fun calculateEarningRate(): Double {
        return rateAsScaledDouble(
            rewardPrice.div(purchasePrice)
        )
    }

    private fun rateAsScaledDouble(earningRate: Double, scale: Int = DEFAULT_RATE_SCALE): Double {
        return BigDecimal(earningRate)
            .setScale(scale, RoundingMode.HALF_EVEN)
            .toDouble()
    }

    companion object {
        const val DEFAULT_RATE_SCALE = 2
    }
}