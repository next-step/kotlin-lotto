package lotto

import kotlin.math.roundToInt

object LottoProgram {
    private const val UNIT = 1000
    private const val DECIMAL_STANDARD = 100.0

    fun getAmountOfLotto(amountOfMoney: Int): Int {
        validateMoneyUnit(amountOfMoney)
        return amountOfMoney / UNIT
    }

    fun calculateRateOfReturn(results: List<Rank>, amountOfMoney: Int): Double {
        val prizeSum = results.sumBy { it.prize }
        if (prizeSum == 0) return 0.0
        return (prizeSum / amountOfMoney.toDouble() * DECIMAL_STANDARD).roundToInt() / DECIMAL_STANDARD
    }

    private fun validateMoneyUnit(amountOfMoney: Int) {
        if (amountOfMoney % UNIT != 0 || amountOfMoney == 0) {
            throw UnitException("1000원 단위만 입력할 수 있습니다.")
        }
    }
}
