package lotto

import java.math.BigDecimal
import java.math.RoundingMode

class Calculator {

    fun calculateRateOfReturn(money: Int, winningMoney: Int): Double {
        return BigDecimal(winningMoney.toDouble() / money.toDouble())
            .setScale(2, RoundingMode.DOWN)
            .toDouble()
    }
}