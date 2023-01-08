package lotto.domain

import java.math.RoundingMode
import java.text.DecimalFormat

class ProfitRate(
    private val matchResult: Map<Ranking, Int>,
    private val inputPrice: Int
) {

    fun calculate(): Double {
        val totalWinningMoney = getTotalWinningMoney()
        return calculate(totalWinningMoney)
    }

    private fun getTotalWinningMoney(): Int {
        return matchResult.entries
            .sumOf { it.key.getTotalWinningMoney(it.value) }
    }

    private fun calculate(totalWinningMoney: Int): Double {
        val decimalFormat = DecimalFormat(PROFIT_RATE_PATTERN)
        decimalFormat.roundingMode = RoundingMode.DOWN
        val profitRate = totalWinningMoney / inputPrice.toDouble()
        return decimalFormat.format(profitRate).toDouble()
    }

    companion object {
        private const val PROFIT_RATE_PATTERN = "#.##"
    }
}
