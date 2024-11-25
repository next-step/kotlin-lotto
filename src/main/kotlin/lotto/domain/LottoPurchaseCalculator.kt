package lotto.domain

object LottoPurchaseCalculator {
    private const val LOTTO_PRICE = 1000

    fun calculateTicketCount(amount: Int): Int {
        require(amount >= 0) { "Amount should be greater than or equal to 0" }
        return amount / LOTTO_PRICE
    }
}
