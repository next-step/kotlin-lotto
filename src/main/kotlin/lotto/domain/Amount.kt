package lotto.domain

import lotto.error.InvalidAmountException

@JvmInline
value class Amount(
    val value: Int
) {
    init {
        require(value >= 0) { throw InvalidAmountException(value) }
    }

    fun toDouble(): Double =
        value.toDouble()

    operator fun plus(other: Amount): Amount =
        Amount(value + other.value)

    operator fun times(count: Int): Amount =
        Amount(value * count)

    operator fun div(other: Amount): Int =
        value / other.value

    operator fun rem(other: Amount): Int =
        value % other.value
}

fun List<Amount>.sum(): Amount = this.fold(Amount(0)) { acc, amount ->
    acc + amount
}
