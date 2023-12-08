package lotto.provider.ticket

import lotto.domain.LottoTickets

class MockLottoShop(private val ticketProvideStrategy: ExactTicketProvideStrategy) : LottoShop {
    override fun provideAutoTickets(ticketCount: Int): LottoTickets = ticketProvideStrategy.provide(ticketCount)
    override fun provideManualTickets(ticketCount: Int): LottoTickets = LottoTickets(listOf())
}
