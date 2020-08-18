package lotto

import kotlin.math.roundToInt

object LottoProgram {
    private const val LOTTO_COUNT = 6
    private const val MIN_NUMBER = 1
    private const val MAX_NUMBER = 45
    private val NUMBER_RANGE = (MIN_NUMBER..MAX_NUMBER)
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

    fun getRandomNumbers(): List<Int> {
        return NUMBER_RANGE.shuffled().take(LOTTO_COUNT).sorted()
    }
}
