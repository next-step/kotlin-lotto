package lotto.provider.ticket

import lotto.domain.LottoTickets

class ManualTicketProvideStrategy(private val lottoTickets: LottoTickets) : TicketProvideStrategy {
    override fun provide(ticketCount: Int): LottoTickets = lottoTickets
}
