package lotto

data class Profit(
    private val purchaseAmount: Money,
    private val matchResults: List<MatchResult>,
) {
    val value: Double
        get() = priceTotal / purchaseAmount.amount

    private val priceTotal: Double
        get() = matchResults.sumOf { it.winCount * it.price.amount }.toDouble()
}
