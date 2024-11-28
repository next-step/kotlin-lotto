package lotto.domain

class DefaultLottoPurchaseCalculator : LottoPurchaseCalculator {
    private companion object {
        const val LOTTO_PRICE = 1000
    }

    override fun calculateTicketCount(amount: Int): Int {
        require(amount >= 0) { "Amount should be greater than or equal to 0" }
        return amount / LOTTO_PRICE
    }
}
