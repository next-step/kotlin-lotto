package domain

data class Money(val value: Int) {
    operator fun plus(other: Money): Money {
        return Money(this.value + other.value)
    }

    operator fun times(number: Int): Money {
        return Money(this.value * number)
    }

    init {
        require(value >= 0)
    }

    companion object {
        val ZERO = Money(0)
    }
}
