package lotto.vo

@JvmInline
value class Money(
    val amount: Long,
) {
    constructor(amount: Int) : this(amount.toLong())

    init {
        require(amount >= 0)
    }

    operator fun plus(other: Money): Money {
        return Money(this.amount + other.amount)
    }

    operator fun times(amount: Int): Money {
        return Money(this.amount * amount)
    }

    override fun toString(): String {
        return amount.toString()
    }
}
