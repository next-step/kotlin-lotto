package lotto.domain

class DefaultLottoPurchaseCalculator : LottoPurchaseCalculator {
    override fun calculateTicketCount(amount: Int): Int {
        require(amount >= 0) { "Amount should be greater than or equal to 0" }
        return amount / LOTTO_PRICE
    }

    private companion object {
        const val LOTTO_PRICE = 1000
    }
}
