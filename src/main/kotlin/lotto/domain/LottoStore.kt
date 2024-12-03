package lotto.domain

class LottoStore(private val lottoGenerator: LottoGenerator) {
    fun sell(autoTicketAmount: PurchaseAmount): LottoTickets {
        return generateAutoTickets(autoTicketAmount.getValue())
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
