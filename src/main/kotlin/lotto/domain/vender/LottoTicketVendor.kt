package lotto.domain.vender

import lotto.domain.ticket.LottoTicket
import lotto.domain.value.Price

class LottoTicketVendor : TicketVendor {
    override fun buyAutomaticTicket(price: Price): List<LottoTicket> {
        val amount = price / TICKET_PRICE

        val tickets = mutableListOf<LottoTicket>()
        repeat(amount.toInt()) {
            tickets.add(LottoTicket.create())
        }
        return tickets
    }

    companion object {
        const val TICKET_PRICE: Long = 1000
    }
}
