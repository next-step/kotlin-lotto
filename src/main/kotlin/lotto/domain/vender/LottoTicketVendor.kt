package lotto.domain.vender

import lotto.domain.ticket.LottoTicket

class LottoTicketVendor : TicketVendor {
    override fun buyAutomaticTicket(price: Int): List<LottoTicket> {
        val amount = price / TICKET_PRICE

        val tickets = mutableListOf<LottoTicket>()
        repeat(amount) {
            tickets.add(LottoTicket.create())
        }
        return tickets
    }

    companion object {
        const val TICKET_PRICE: Int = 1000
    }
}
