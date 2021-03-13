package lotto.domain.vender

import lotto.domain.ticket.LottoTicket
import lotto.domain.value.Price

class LottoTicketVendor : TicketVendor {
    override fun buyAutomaticTicket(price: Price): List<LottoTicket> {
        val amount = price / TICKET_PRICE

        return (0 until amount).map {
            LottoTicket.create()
        }
    }

    companion object {
        const val TICKET_PRICE: Long = 1000
    }
}
