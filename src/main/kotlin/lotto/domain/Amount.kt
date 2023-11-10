package lotto.domain

@JvmInline
value class Amount(
    val value: Int
) {
    init {
        require(value >= 0) { "금액은 0보다 크거나 같아야 합니다" }
    }

    fun calculateEarningRate(purchasedAmount: Amount): EarningRate {
        val earningRate = value.toDouble() / purchasedAmount.value
        return ((earningRate * 100).toInt() / 100.0).let(::EarningRate)
    }

    operator fun plus(other: Amount): Amount =
        Amount(value + other.value)

    operator fun times(count: Int): Amount =
        Amount(value * count)

    operator fun div(other: Amount): Int =
        value / other.value

    operator fun rem(other: Amount): Int =
        value % other.value
}
