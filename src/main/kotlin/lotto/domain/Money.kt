package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

@JvmInline
value class Money private constructor(val value: BigDecimal) {

    fun count(price: Money): Int {
        return this.value.divide(price.value, RoundingMode.HALF_EVEN).intValueExact()
    }

    companion object {
        fun valueOf(value: Int): Money {
            return valueOf(value.toBigDecimal())
        }

        fun valueOf(value: Long): Money {
            return valueOf(BigDecimal.valueOf(value))
        }

        fun valueOf(value: BigDecimal): Money {
            return Money(value)
        }
    }
}
