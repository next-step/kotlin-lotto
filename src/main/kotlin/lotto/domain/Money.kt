package lotto.domain

data class Money(val value: Int) {

    init {
        require(value == 0 || (value >= 1000 && value % 1000 == 0))
    }

    operator fun div(money: Money): Int {
        require(money.value != 0)
        return value / money.value
    }

    companion object {
        val ZERO = Money(0)
    }
}
