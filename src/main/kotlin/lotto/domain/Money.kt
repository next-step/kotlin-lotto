package lotto.domain

data class Money(val value: Int) {

    init {
        require(value == 0 || (value >= UNIT_AMOUNT && value % UNIT_AMOUNT == 0)) {
            "${UNIT_AMOUNT}원 단위의 금액만 받습니다. $value"
        }
    }

    operator fun div(money: Money): Double {
        require(money != ZERO) { "0으로는 나눌수가 없습니다." }
        return value.toDouble() / money.value.toDouble()
    }

    operator fun times(int: Int) = copy(value = value * int)

    operator fun plus(money: Money) = copy(value = value + money.value)

    companion object {
        private val UNIT_AMOUNT = 1000
        val ZERO = Money(0)
    }
}
