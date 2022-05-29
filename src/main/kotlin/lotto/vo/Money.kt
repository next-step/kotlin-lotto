package lotto.vo

import java.math.BigDecimal
import java.math.RoundingMode

@JvmInline
value class Money(val amount: BigDecimal) : Comparable<Money> {

    init {
        require(amount >= BigDecimal.ZERO) {
            "금액은 0원 이상이어야 합니다 (입력:$amount)"
        }
    }

    override fun compareTo(other: Money): Int {
        return amount.compareTo(other.amount)
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
        fun of(amount: Int): Money {
            return Money(amount.toBigDecimal())
        }
    }
}
