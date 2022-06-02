package lotto.domain

@JvmInline
value class Money(val amount: Int) {
    init {
        require(amount >= 0) { "돈은 0 이상이여야 한다." }
    }

    operator fun times(int: Int): Money {
        return Money(amount * int)
    }

    operator fun div(other: Money): Int {
        return amount / other.amount
    }
}
