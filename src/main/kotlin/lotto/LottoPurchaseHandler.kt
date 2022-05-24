package lotto

object LottoPurchaseHandler {

    fun getLottoCountByAmount(amount: Int): LottoPriceRule {
        val count = amount / PRICE_PER_LOTTO
        val change = amount % PRICE_PER_LOTTO

        return LottoPriceRule(count, amount, change)
    }

    const val PRICE_PER_LOTTO = 1000
}