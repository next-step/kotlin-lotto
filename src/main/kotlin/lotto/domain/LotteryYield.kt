package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

@JvmInline
value class LotteryYield private constructor(val ratio: BigDecimal) {

    companion object {
        private fun calculate(paid: Money, reward: Money): BigDecimal {
            return reward.value.divide(paid.value, 3, RoundingMode.HALF_EVEN).setScale(2, RoundingMode.HALF_DOWN)
        }

        fun of(paid: Money, reward: Money): LotteryYield {
            val ratio = calculate(paid, reward)
            return LotteryYield(ratio)
        }
    }
}
