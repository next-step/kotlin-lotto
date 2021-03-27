package lotto.domain.vender

import lotto.domain.ticket.LottoTicket

abstract class TicketVendor {
    abstract fun buyTickets(): List<LottoTicket>

    companion object {
        const val TICKET_PRICE: Long = 1000
    }
}
