package lotto

import java.math.BigDecimal
import java.math.RoundingMode

@JvmInline
value class Amount(val value: BigDecimal) {
    init {
        require(value >= BigDecimal.ZERO) { "음수는 입력할 수 없습니다." }
    }

    constructor(str: String) : this(BigDecimal(str))

    fun plus(other: Amount): Amount {
        return Amount(value + other.value)
    }

    fun rate(amount: Amount): BigDecimal {
        return value.divide(amount.value, 2, RoundingMode.DOWN)
    }

    fun multiply(otherValue: Int): Amount {
        return Amount(value * otherValue.toBigDecimal())
    }

    fun divide(other: Amount): Int {
        return (value / other.value).toInt()
    }

    companion object {
        val ZERO: Amount = Amount(BigDecimal.ZERO)
    }
}
