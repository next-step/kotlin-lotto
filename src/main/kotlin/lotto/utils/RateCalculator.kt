package lotto.utils

import java.math.BigDecimal
import java.math.RoundingMode

class RateCalculator {

    fun calculateRateOfReturn(money: Int, winningMoney: Int): Double {
        return BigDecimal(winningMoney.toDouble() / money.toDouble())
            .setScale(SECOND_DECIMAL_PLACE, RoundingMode.DOWN)
            .toDouble()
    }

    companion object {
        private const val SECOND_DECIMAL_PLACE = 2
    }
}
