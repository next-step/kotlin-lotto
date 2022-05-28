package lotto.domain

@JvmInline
value class Money(val money: Int = 0) {

    init {
        require(money >= MIN_MONEY)
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
    }
}
