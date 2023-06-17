package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

data class Money(val value: Long) {
    operator fun plus(other: Money): Money = Money(this.value + other.value)
    operator fun minus(other: Money): Money = Money(this.value - other.value)
    operator fun times(other: Money): Money = Money(this.value * other.value)
    operator fun times(other: Int): Money = Money(this.value * other)

    operator fun div(other: Money): BigDecimal {
        if (other.value == 0L) throw ArithmeticException("0으로 나눌 수 없습니다.")
        return (BigDecimal(this.value).divide(BigDecimal(other.value), MINIMUM_SCALE, RoundingMode.HALF_UP))
    }

    companion object {
        private const val MINIMUM_SCALE = 2
    }
}
