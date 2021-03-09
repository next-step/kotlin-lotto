package lotto.domain

data class Money(val value: Int) {

    init {
        require(value == 0 || (value >= 1000 && value % 1000 == 0))
    }

    operator fun div(money: Money): Double {
        require(money.value != 0)
        return value.toDouble() / money.value.toDouble()
    }

    operator fun times(int: Int) = copy(value = value * int)

    operator fun plus(money: Money) = copy(value = value + money.value)

    companion object {
        val ZERO = Money(0)
    }
}
