package lotto.provider.ticket

import lotto.domain.AutoTicketProvideStrategy
import lotto.domain.LottoTickets

object AutoTicketProvider : LottoTicketsProvider(AutoTicketProvideStrategy) {
    override fun provide(ticketCount: Int): LottoTickets = ticketProvideStrategy.provide(ticketCount)
}
