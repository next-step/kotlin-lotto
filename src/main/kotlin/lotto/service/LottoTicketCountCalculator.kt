package lotto.service

object LottoTicketCountCalculator {
    private const val LOTTO_PRICE = 1000

    fun getCount(purchaseAmount: Int) : Int = purchaseAmount / LOTTO_PRICE
}
