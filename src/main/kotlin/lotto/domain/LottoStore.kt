package lotto.domain

class LottoStore(private val lottoGenerator: LottoGenerator) {
    fun sell(amount: Int): LottoTickets {
        require(amount >= LOTTO_PRICE) { "Insufficient amount to buy lotto tickets." }
        val ticketCount = amount / LOTTO_PRICE
        val tickets = List(ticketCount) { lottoGenerator.generateTicket() }
        return LottoTickets(tickets)
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
