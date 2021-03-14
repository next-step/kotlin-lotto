package lotto.model

data class Money(val amount: Int) {
    operator fun div(price: Money): Double {
        return amount.toDouble() / price.amount.toDouble()
    }

    operator fun times(other: Int): Money {
        return Money(amount * other)
    }

    operator fun plus(other: Money): Money {
        return Money(amount + other.amount)
    }

    companion object {
        val zero = Money(0)
        val thousand = Money(1000)
    }
}
