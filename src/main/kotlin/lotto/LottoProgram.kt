package lotto

import kotlin.math.roundToInt

object LottoProgram {
    private const val UNIT = 1000
    private const val DECIMAL_STANDARD = 100.0

    fun getAmountOfLotto(amountOfMoney: Int): Int {
        return amountOfMoney / UNIT
    }

    fun calculateRateOfReturn(results: List<Rank>, amountOfMoney: Int): Double {
        val prizeSum = results.sumBy { it.prize }
        if (prizeSum == 0) return 0.0
        return (prizeSum / amountOfMoney.toDouble() * DECIMAL_STANDARD).roundToInt() / DECIMAL_STANDARD
    }
}
