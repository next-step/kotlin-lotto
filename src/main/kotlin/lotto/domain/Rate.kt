package lotto.domain

import java.text.DecimalFormat
import kotlin.math.floor
import kotlin.math.pow

class Rate(private val winAmount: Amount, private val amount: Amount) {

    fun toReturn(): Double {
        return roundDownDigit(amount.divide(winAmount), 2)
    }

    private fun roundDownDigit(number: Double, digits: Int): Double {
        return floor(number * Math.pow(10.0, digits.toDouble())) / 10.0.pow(digits.toDouble())
    }
}