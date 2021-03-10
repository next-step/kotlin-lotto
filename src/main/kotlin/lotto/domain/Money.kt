package lotto.domain

internal data class Money(val value: Int) {

    init {
        require(value >= MIN_VALUE) {
            "the value is more than $MIN_VALUE"
        }
    }

    internal operator fun plus(money: Money): Money {
        return Money(this.value + money.value)
    }

    internal operator fun minus(money: Money): Money {
        return Money(this.value - money.value)
    }

    internal operator fun times(money: Money): Money {
        return Money(this.value * money.value)
    }

    internal operator fun div(money: Money): Money {
        return Money(this.value / money.value)
    }

    companion object {
        private const val MIN_VALUE = 1
    }
}
