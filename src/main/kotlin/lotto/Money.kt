package lotto

@JvmInline
value class Money(val amount: Int) : Comparable<Money> {
    operator fun plus(other: Money): Money {
        return Money(amount + other.amount)
    }

    operator fun minus(other: Money): Money {
        return Money(amount - other.amount)
    }

    override operator fun compareTo(other: Money): Int {
        return amount.compareTo(other.amount)
    }

    fun toInt(): Int {
        return amount
    }

    fun toDouble(): Double {
        return amount.toDouble()
    }

    companion object {
        val ZERO = Money(0)
    }
}
