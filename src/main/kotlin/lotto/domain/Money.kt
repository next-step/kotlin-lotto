package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

@JvmInline
value class Money private constructor(val value: BigDecimal) {

    fun count(price: Money): Int {
        return this.value.divide(price.value, RoundingMode.HALF_EVEN).intValueExact()
    }

    companion object {
        fun from(value: Int): Money {
            return from(value.toBigDecimal())
        }

        fun from(value: Long): Money {
            return from(BigDecimal.valueOf(value))
        }

        fun from(value: BigDecimal): Money {
            return Money(value)
        }
    }
}
