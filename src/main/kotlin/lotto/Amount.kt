package lotto

import java.math.BigDecimal

@JvmInline
value class Amount(val value: BigDecimal) {
    init {
        require(value >= BigDecimal.ZERO) { "음수는 입력할 수 없습니다." }
    }

    constructor(str: String) : this(str.toBigDecimalOrNull() ?: throw IllegalArgumentException("숫자가 아닙니다."))
    constructor(toInt: Int) : this(toInt.toBigDecimal())

    operator fun minus(other: Amount): Amount {
        return Amount(value - other.value)
    }

    operator fun times(size: Int): Amount {
        return Amount(value * size.toBigDecimal())
    }

    operator fun div(other: Amount): Int {
        return (value / other.value).toInt()
    }

    fun isLessThan(other: Amount): Boolean {
        return value < other.value
    }
}
