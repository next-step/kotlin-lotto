package lotto

object LottoPurchaseHandler {

    fun calculateLottoCountByAmount(amount: Int, directCount: Int): LottoPriceRule {
        val directPurchaseAmount = directCount * PRICE_PER_LOTTO

        val autoPurchaseAmount = amount - directPurchaseAmount
        require(autoPurchaseAmount > 0)

        val autoPurchaseCount = autoPurchaseAmount / PRICE_PER_LOTTO
        val change = amount % PRICE_PER_LOTTO

        return LottoPriceRule(autoPurchaseCount, amount, change)
    }

    private const val PRICE_PER_LOTTO = 1000
}
