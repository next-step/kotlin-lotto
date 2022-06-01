package lotto

object LottoPurchaseHandler {

    fun calculateLottoCountByAmount(amount: Int): LottoPriceRule {
        val count = amount / PRICE_PER_LOTTO
        val change = amount % PRICE_PER_LOTTO

        return LottoPriceRule(count, amount, change)
    }

    private const val PRICE_PER_LOTTO = 1000
}
