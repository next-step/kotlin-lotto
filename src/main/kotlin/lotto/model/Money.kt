package lotto.model

data class Money(val amount: Int) {

    operator fun plus(other: Money): Money {
        return Money(amount + other.amount)
    }

    operator fun times(other: Int): Money {
        return Money(amount * other)
    }

    operator fun div(other: Money): Double {
        return amount.toDouble() / other.amount.toDouble()
    }

    companion object {
        val THOUSAND = Money(1000)
        val ZERO = Money(0)
    }
}
