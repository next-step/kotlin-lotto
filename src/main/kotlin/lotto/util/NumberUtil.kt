package lotto.util

import lotto.common.DoubleNumber

object NumberUtil {
    fun floor(number: DoubleNumber, decimalPlace: DoubleNumber): DoubleNumber {
        if (decimalPlace.isNegative()) {
            return number
        }
        val pow = DoubleNumber(10.0).pow(decimalPlace)
        val floor = number.multiply(pow).floor()
        return floor.divide(pow)
    }
}
