package lotto.domain

class Amount(private val value: Long) {

    constructor(value: Int) : this(value.toLong())

    fun divide(price: Int): Int {
        return (value / price).toInt()
    }

    fun divide(amount: Amount): Double {
        return value.toDouble() / amount.value.toDouble()
    }

    fun sub(amount: Amount): Amount {
        return Amount(value - amount.value)
    }
}