package lotto.domain.vender

import lotto.domain.ticket.LottoTicket

interface TicketVendor {
    fun buyAutomaticTicket(price: Int): List<LottoTicket>
}
