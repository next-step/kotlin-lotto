package lotto.util

import kotlin.math.floor
import kotlin.math.pow

object NumberUtil {

    fun floor(number: Double, decimalPlace: Int): Double {
        if (decimalPlace == -1) {
            return number
        }

        val pow = 10.0.pow(decimalPlace.toDouble())
        val floor = floor(number * pow)
        return floor / pow
    }
}
