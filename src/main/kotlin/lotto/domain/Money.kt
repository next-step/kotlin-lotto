package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

data class Money(val value: Long) : Comparable<Money> {

    init {
        check(value >= 0) { "돈은 음수가 될 수 없습니다. value: $value" }
    }

    constructor(value: Int) : this(value.toLong())

    operator fun plus(other: Money): Money {
        return Money(this.value + other.value)
    }

    operator fun times(other: PositiveNumber): Money {
        return Money(this.value * other.value)
    }

    operator fun minus(other: Money): Money {
        return Money(this.value - other.value)
    }

    operator fun div(other: Money): Int {
        require(other != EMPTY) { "나누는 돈이 0원입니다." }
        return (this.value / other.value).toInt()
    }

    operator fun rem(other: Money): Money {
        require(other != EMPTY) { "나누는 돈이 0원입니다." }
        return Money(this.value % other.value)
    }

    override fun compareTo(other: Money): Int {
        return this.value.compareTo(other.value)
    }

    fun rateOf(other: Money): BigDecimal {
        require(other != EMPTY) { "나누는 돈이 0원입니다." }
        val thisValue = BigDecimal(this.value)
        val otherValue = BigDecimal(other.value)
        return thisValue.divide(otherValue, NUMBER_OF_DIGITS_AFTER_THE_DECIMAL_POINT, RoundingMode.HALF_EVEN)
    }

    companion object {
        val EMPTY = Money(0)
        private const val NUMBER_OF_DIGITS_AFTER_THE_DECIMAL_POINT = 6
    }
}
