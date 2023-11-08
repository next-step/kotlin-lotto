package lotto.domain

@JvmInline
value class Amount(
    val value: Int
) {
    init {
        require(value >= 0) { "금액은 0보다 크거나 같아야 합니다" }
    }

    fun purchase(productPrice: Amount): ProductCount =
        ProductCount(calculateCount(productPrice))

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

    private fun calculateCount(productPrice: Amount): Int {
        require(this % productPrice == 0) { "구매하려면 구매 금액이 상품 금액의 배수여야 합니다" }
        return this / productPrice
    }
}


