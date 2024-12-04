package lotto.domain

class LottoStore(private val lottoGenerator: LottoGenerator) {
    fun sell(
        manualTickets: LottoTickets,
        autoTicketAmount: PurchaseAmount,
    ): LottoTickets {
        val autoTickets = generateAutoTickets(autoTicketAmount.getValue())
        return LottoTickets.combine(manualTickets.getTickets(), autoTickets.getTickets())
    }

    private fun generateAutoTickets(amount: Int): LottoTickets {
        val ticketCount = amount / LOTTO_PRICE
        val tickets = List(ticketCount) { lottoGenerator.generateTicket() }
        return LottoTickets(tickets)
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
