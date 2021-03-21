package domain.money

data class Money(val value: Int) : Comparable<Money> {
    operator fun plus(other: Money): Money {
        return Money(this.value + other.value)
    }

    operator fun times(number: Int): Money {
        return Money(this.value * number)
    }

    override fun compareTo(other: Money): Int {
        return this.value.compareTo(other.value)
    }

    fun dividedBy(other: Money): Int {
        return this.value / other.value
    }

    init {
        require(value >= 0)
    }

    companion object {
        val ZERO = Money(0)
    }
}
