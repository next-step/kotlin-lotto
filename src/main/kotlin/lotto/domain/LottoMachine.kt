package lotto.domain

class LottoMachine(private val ticketPrice: Int) {

    fun generateTickets(amount: Int): List<LottoTicket> {
        val ticketCount = amount / ticketPrice
        return List(ticketCount) { LottoTicket.generate() }
    }
}
