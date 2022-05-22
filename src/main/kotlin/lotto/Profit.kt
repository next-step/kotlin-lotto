package lotto

data class Profit(
    private val purchaseAmount: Money,
    private val matchResults: List<MatchResult>,
) {
    val value: Double
        get() = 1.0
}
