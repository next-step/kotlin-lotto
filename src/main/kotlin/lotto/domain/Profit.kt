package lotto.domain

data class Profit(
    private val purchaseAmount: Money,
    private val lottoMatchResults: List<LottoMatchResult>,
) {
    val value: Double
        get() = priceTotal / purchaseAmount.amount

    private val priceTotal: Double
        get() = lottoMatchResults.sumOf { it.winCount * it.price.amount }.toDouble()
}
