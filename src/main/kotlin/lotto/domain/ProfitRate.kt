package lotto.domain

import java.math.RoundingMode
import java.text.DecimalFormat

class ProfitRate(
    private val matchResult: Map<Rank, Int>,
    private val inputPrice: Int,
) {
    fun calculate(): Double {
        val totalWinningMoney = getTotalWinningMoney()
        return calculate(totalWinningMoney)
    }

    private fun getTotalWinningMoney(): Int {
        return matchResult.keys
            .sumOf { (matchResult[it] ?: DEFAULT_ZERO) * it.winningMoney }
    }

    private fun calculate(totalWinningMoney: Int): Double {
        val decimalFormat = DecimalFormat(PROFIT_RATE_PATTERN)
        decimalFormat.roundingMode = RoundingMode.DOWN
        val profitRate = totalWinningMoney / inputPrice.toFloat()
        return decimalFormat.format(profitRate).toDouble()
    }

    companion object {
        private const val DEFAULT_ZERO = 0
        private const val PROFIT_RATE_PATTERN = "#.##"
    }
}
