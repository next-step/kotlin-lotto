package lotto.domain

@JvmInline
value class Money(val value: Int) {
    init {
        validateMoneyIsPositiveZero(value)
    }

    fun toDouble(): Double {
        return value.toDouble()
    }

    operator fun plus(money: Money): Money {
        return Money(value + money.value)
    }

    operator fun minus(money: Money): Money {
        return Money(value - money.value)
    }

    operator fun compareTo(other: Money): Int {
        return value.compareTo(other.value)
    }

    private fun validateMoneyIsPositiveZero(money: Int) {
        require(money >= 0) { "돈은 0보다 커야 합니다." }
    }
}
