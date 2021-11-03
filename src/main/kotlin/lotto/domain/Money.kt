package lotto.domain

import java.math.BigDecimal

@JvmInline
value class Money private constructor(val value: BigDecimal) {

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
