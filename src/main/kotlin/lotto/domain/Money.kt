package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

@JvmInline
value class Money private constructor(val value: BigDecimal) {

    fun count(price: Money): Int {
        return this.value.divide(price.value, RoundingMode.HALF_EVEN).intValueExact()
    }

    companion object {
        fun of(value: Int): Money {
            return of(value.toBigDecimal())
        }

        fun of(value: Long): Money {
            return of(BigDecimal.valueOf(value))
        }

        fun of(value: BigDecimal): Money {
            return Money(value)
        }
    }
}
