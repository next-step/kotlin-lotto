package lotto.common

import kotlin.math.pow

data class DoubleNumber(
    val number: Double
) {
    constructor(number: IntegerNumber) : this(number.number.toDouble())

    fun divide(other: DoubleNumber): DoubleNumber {
        return DoubleNumber(number.div(other.number))
    }

    fun pow(x: DoubleNumber): DoubleNumber {
        return DoubleNumber(number.pow(x.number))
    }

    fun multiply(other: DoubleNumber): DoubleNumber {
        return DoubleNumber(number.times(other.number))
    }

    fun floor(): DoubleNumber {
        return DoubleNumber(kotlin.math.floor(number))
    }

    fun isNegative(): Boolean {
        return number < 0
    }

    fun isGreaterThanEquals(other: DoubleNumber): Boolean {
        return number >= other.number
    }
}
