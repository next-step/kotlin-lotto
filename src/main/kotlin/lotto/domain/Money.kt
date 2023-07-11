package lotto.domain

import java.math.BigDecimal

@JvmInline
value class Money(val value: BigDecimal) {
    fun divide(other: BigDecimal): BigDecimal {
        return value.divide(other)
    }

    init {
        require(value >= MIN_VALUE) { "금액은 ${MIN_VALUE}원 이상이어야 합니다. [$value]" }
    }

    companion object {
        private val MIN_VALUE = 1_000.toBigDecimal()

        fun from(value: Int): Money {
            return Money(value.toBigDecimal())
        }
    }
}
