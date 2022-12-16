package lotto

class LottoTicketBundle(private val tickets: List<LottoTicket>) {
    fun match(winningNumber: WinningNumber): List<LottoTicket> {
        return tickets.map { ticket ->
            ticket.match(winningNumber = winningNumber)
            ticket
        }
    }
}
