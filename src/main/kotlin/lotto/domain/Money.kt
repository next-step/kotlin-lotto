package lotto.domain

@JvmInline
value class Money(private val value: Int) {
    init {
        require(value >= MINIMUM_MONEY_VALUE) { "금액은 0원 이상이어야 합니다." }
    }

    operator fun div(money: Money): Double {
        require(money != ZERO) { "0원으로는 나눌수 없습니다." }

        return value.toDouble() / money.value.toDouble()
    }

    operator fun times(count: Int): Int {
        return value * count
    }

    companion object {
        val ZERO = Money(0)
        const val MINIMUM_MONEY_VALUE = 0
    }
}
