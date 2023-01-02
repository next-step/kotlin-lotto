package lotto.model

import java.math.BigDecimal
import java.math.RoundingMode.FLOOR
import java.math.RoundingMode.HALF_DOWN

data class Money(private val value: BigDecimal) {
    operator fun plus(other: Money): Money {
        return Money(value + other.value)
    }

    operator fun minus(other: Money): Money {
        return Money(value - other.value)
    }

    operator fun times(other: Int): Money {
        return Money(value * other.toBigDecimal())
    }

    operator fun compareTo(lottoPrice: Money): Int {
        return this.value.compareTo(lottoPrice.value)
    }

    fun getBuyCountOf(lottoPrice: Money): Int {
        return value.divide(lottoPrice.value, BUY_COUNT_SCALE, FLOOR).toInt()
    }

    fun getReturnRatioOf(purchaseAmount: Money): BigDecimal {
        return value.divide(purchaseAmount.value, RETURN_RATIO_SCALE, HALF_DOWN)
    }

    companion object {
        val ZERO = Money(BigDecimal.ZERO)
        private const val BUY_COUNT_SCALE = 0
        private const val RETURN_RATIO_SCALE = 2

        fun of(input: String): Money {
            return Money(input.trim().toBigDecimal())
        }

        fun of(input: Long): Money {
            return Money(BigDecimal.valueOf(input))
        }
    }
}
