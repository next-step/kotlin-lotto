package lotto.domain

import java.math.BigDecimal

@JvmInline
value class Money(val value: BigDecimal) {
    fun divide(other: Money): BigDecimal {
        return value.divide(other.value)
    }

    operator fun compareTo(other: Money): Int {
        return value.compareTo(other.value)
    }

    operator fun rem(other: Money): BigDecimal {
        return value.remainder(other.value)
    }

    companion object {
        fun from(value: Int): Money {
            return Money(value.toBigDecimal())
        }
    }
}
