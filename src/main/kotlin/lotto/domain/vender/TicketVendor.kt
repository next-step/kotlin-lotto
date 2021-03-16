package lotto.domain.vender

import lotto.domain.ticket.LottoTicket
import lotto.domain.value.Price

abstract class TicketVendor {
    abstract fun buyAutomaticTicket(price: Price): List<LottoTicket>

    companion object {
        const val TICKET_PRICE: Long = 1000
    }
}
