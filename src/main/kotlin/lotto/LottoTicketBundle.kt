package lotto

class LottoTicketBundle(private val tickets: List<LottoTicket>) {
    fun match(winningNumber: WinningNumber): List<LottoTicket> {
        return tickets.map { ticket ->
            ticket.match(winningNumber = winningNumber)
            ticket
        }
    }

    fun getTickets(): List<LottoTicket> = this.tickets

    companion object {
        fun purchase(payment: Int): LottoTicketBundle {
            val amount = payment / LottoTicket.LOTTO_TICKET_PRICE
            val tickets = (1..amount)
                .map { LottoTicket.purchase(payment = LottoTicket.LOTTO_TICKET_PRICE) }
            return LottoTicketBundle(tickets = tickets)
        }
    }
}
