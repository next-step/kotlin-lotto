package lotto.vo

@JvmInline
value class Money(
    private val amount: Long,
) : Comparable<Money> {
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

    override fun compareTo(other: Money): Int {
        return amount.compareTo(other.amount)
    }

    override fun toString(): String {
        return amount.toString()
    }

    operator fun div(lottoPrice: Money): Double {
        return amount / (lottoPrice.amount).toDouble()
    }

    operator fun minus(money: Money): Money {
        return Money(amount - money.amount)
    }
}
