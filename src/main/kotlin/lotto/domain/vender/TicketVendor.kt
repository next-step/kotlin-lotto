package lotto.domain.vender

import lotto.domain.ticket.LottoTicket
import lotto.domain.value.Price

interface TicketVendor {
    fun buyAutomaticTicket(price: Price): List<LottoTicket>
}
