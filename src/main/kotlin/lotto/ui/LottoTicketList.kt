package lotto.ui

import lotto.LottoTicket

class LottoTicketList(private val tickets: List<LottoTicket>) : UI {
    override fun draw() {
        this.tickets.forEach { ticket ->
            LottoTicketItem(ticket = ticket).draw()
        }
    }
}
