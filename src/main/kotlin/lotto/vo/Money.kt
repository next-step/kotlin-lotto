package lotto.vo

import java.math.BigDecimal
import java.math.RoundingMode

data class Money(val amount: BigDecimal) {

    init {
        require(amount >= BigDecimal.ZERO) {
            "금액은 0원 이상이어야 합니다 (입력:$amount)"
        }
    }

    operator fun plus(other: Money): Money {
        return Money(amount + other.amount)
    }

    operator fun div(other: Money): Int {
        return (amount / other.amount).toInt()
    }

    fun divide(other: Money, scale: Int, roundingMode: RoundingMode): BigDecimal {
        return amount.divide(other.amount, scale, roundingMode)
    }

    fun multiply(count: Int): Money {
        return Money(amount.multiply(count.toBigDecimal()))
    }

    companion object {
        val ZERO = Money(BigDecimal.ZERO)

        fun of(amount: Int): Money {
            return Money(amount.toBigDecimal())
        }
    }
}
