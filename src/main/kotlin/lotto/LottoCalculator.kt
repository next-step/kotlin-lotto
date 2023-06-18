package lotto

import java.math.RoundingMode
import java.text.DecimalFormat

object LottoCalculator {
    private const val DECIMAL_PATTERN = "#.##"
    private val decimalFormat = DecimalFormat(DECIMAL_PATTERN).apply {
        roundingMode = RoundingMode.DOWN
    }

    fun earningRate(results: List<Int>, money: Int): String {
        var totalPrize = 0
        results.forEachIndexed { index, i ->
            totalPrize += i * when (index) {
                3 -> Lotto.THREE_MATCH_PRIZE
                4 -> Lotto.FOUR_MATCH_PRIZE
                5 -> Lotto.FIVE_MATCH_PRIZE
                6 -> Lotto.SIX_MATCH_PRIZE
                else -> 0
            }
        }
        return decimalFormat.format(totalPrize.toDouble() / money.toDouble())
    }
}
