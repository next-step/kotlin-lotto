package lotto.domain

class LottoStore(
    private val lottoGenerator: LottoGenerator,
    private val purchaseCalculator: LottoPurchaseCalculator,
) {
    fun sell(amount: Int): List<Lotto> {
        val ticketCount = purchaseCalculator.calculateTicketCount(amount)
        return List(ticketCount) { lottoGenerator.generateTicket() }
    }
}
