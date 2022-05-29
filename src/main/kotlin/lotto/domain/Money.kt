package lotto.domain

@JvmInline
value class Money(val money: Int = 0) {

    init {
        require(money >= MIN_MONEY) { ERROR_MSG_NEGATIVE_MONEY }
    }

    fun getLottoCount(): Int {
        return money / EACH_LOTTO_PRICE
    }

    operator fun plus(other: Money): Money {
        return Money(money + other.money)
    }

    companion object {
        private const val EACH_LOTTO_PRICE = 1000
        private const val MIN_MONEY = 0
        private const val ERROR_MSG_NEGATIVE_MONEY = "돈은 음수가 될 수 없습니다."
    }
}
