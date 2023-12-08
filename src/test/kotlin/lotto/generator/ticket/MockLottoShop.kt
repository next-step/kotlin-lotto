package lotto.generator.ticket

import lotto.domain.LottoTickets

class MockLottoShop(private val ticketGenerateStrategy: ExactTicketGenerator) : LottoShop {
    override fun provideAutoTickets(ticketCount: Int): LottoTickets = ticketGenerateStrategy.create(ticketCount)
    override fun provideManualTickets(ticketCount: Int): LottoTickets = LottoTickets(listOf())
}
