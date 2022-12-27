package lotto.util

import kotlin.math.pow

object NumberUtil {
    fun floor(number: Double, decimalPlace: Double): Double {
        if (decimalPlace < 0) {
            return number
        }
        val pow = 10.0.pow(decimalPlace)
        val floor = kotlin.math.floor(number * pow)
        return floor / pow
    }
}
