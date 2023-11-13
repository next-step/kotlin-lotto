package lotto.provider.ticket

import lotto.domain.LottoTickets

class MockTicketProvider(ticketProvideStrategy: ManualTicketProvideStrategy) : LottoTicketsProvider(ticketProvideStrategy) {
    override fun provide(ticketCount: Int): LottoTickets = ticketProvideStrategy.provide(ticketCount)
}
