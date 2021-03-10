package lotto

data class Money(val amount: Long) {

    constructor(amount: Int) : this(amount.toLong())

    operator fun div(divisor: Money): Int {
        require(divisor.amount != 0L)
        return (amount / divisor.amount).toInt()
    }

    operator fun times(other: Int): Long = amount * other
}
