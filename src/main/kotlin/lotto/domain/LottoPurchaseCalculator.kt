package lotto.domain

interface LottoPurchaseCalculator {
    fun calculateTicketCount(amount: Int): Int
}
