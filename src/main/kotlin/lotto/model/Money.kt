package lotto.model

data class Money(val amount: Int) {
    fun dividedBy(price: Money): Double {
        return amount.toDouble() / price.amount.toDouble()
    }

    fun times(other: Int): Money {
        return Money(amount * other)
    }

    fun add(other: Money): Money {
        return Money(amount + other.amount)
    }

    companion object {
        fun zero(): Money {
            return Money(0)
        }
    }
}
