package lotto.domain

private const val MIN_MONEY = 0

data class Money(val value: Int) {

    init {
        require(value >= MIN_MONEY) { "금액은 0원 아래가 될 수 없어요." }
    }

    fun hasMore(price: Int) = value >= price

    fun isNotChangeLeft(price: Int) = value % price == 0

    fun useMoney(price: Int) = of(value - price)

    companion object {
        fun of(value: Int): Money {
            return Money(value)
        }
    }
}
