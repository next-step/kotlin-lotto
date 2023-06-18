package lotto

import java.math.RoundingMode
import java.text.DecimalFormat

object LottoCalculator {
    private const val DECIMAL_PATTERN = "#.##"
    private val decimalFormat = DecimalFormat(DECIMAL_PATTERN).apply {
        roundingMode = RoundingMode.DOWN
    }

    fun earningRate(results: List<Int>, money: Int): Double {
        var totalPrize = 0.0
        results.forEachIndexed { index, i ->
            totalPrize += i * Lotto.prizes[index]
        }

        if (money == 0) return 0.0

        return decimalFormat.format(totalPrize / money).toDouble()
    }
}
