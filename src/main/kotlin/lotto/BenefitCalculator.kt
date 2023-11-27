package lotto

import java.math.RoundingMode
import java.text.DecimalFormat

class BenefitCalculator {
    fun calculate(result: Map<Int, Int>): String {
        val spend = result.map { it.value }.sum() * LOTTO_PRICE
        val benefit = result.map { 
            when (it.key) {
                1 -> WINNER_REWARD * it.value
                2 -> SECOND_REWARD * it.value
                3 -> THIRD_REWARD * it.value
                4 -> FORTH_REWARD * it.value
                else -> 0
            }
        }.sum()
        
        val rate = benefit.toDouble() / spend
        df.roundingMode = RoundingMode.FLOOR
        return df.format(rate)
    }
    
    companion object {
        private const val WINNER_REWARD = 2000000000
        private const val SECOND_REWARD = 1500000
        private const val THIRD_REWARD = 50000
        private const val FORTH_REWARD = 5000
        private const val LOTTO_PRICE = 1000
        private val df = DecimalFormat("0.00")
    }
}
