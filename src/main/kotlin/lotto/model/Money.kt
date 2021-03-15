package lotto.model

import java.math.BigDecimal
import java.math.RoundingMode

data class Money(val amount: Int) {

    operator fun plus(other: Money): Money {
        return Money(amount + other.amount)
    }

    operator fun times(other: Int): Money {
        return Money(amount * other)
    }

    operator fun div(other: Money): Double {
        return BigDecimal(amount).divide(BigDecimal(other.amount), 8, RoundingMode.CEILING).toDouble()
    }

    companion object {
        val THOUSAND = Money(1000)
        val ZERO = Money(0)
    }
}
