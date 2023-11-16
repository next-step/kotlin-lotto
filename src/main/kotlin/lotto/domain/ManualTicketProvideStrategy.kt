package lotto.domain

import lotto.provider.ticket.TicketProvideStrategy

class ManualTicketProvideStrategy(private val lottoTickets: LottoTickets) : TicketProvideStrategy {
    override fun provide(ticketCount: Int): LottoTickets = lottoTickets
}
