package lotto.step4.domain

@JvmInline
value class Money(val value: Long) {
    operator fun plus(other: Money): Money {
        return Money(this.value + other.value)
    }

    operator fun minus(other: Money): Money {
        return Money(this.value - other.value)
    }

    fun multiply(count: Long): Money {
        return Money(this.value * count)
    }

    operator fun div(other: Money): Long {
        if (other.value == 0L) {
            return 0
        }
        return this.value / other.value
    }

    override fun toString(): String {
        return value.toString()
    }
}
