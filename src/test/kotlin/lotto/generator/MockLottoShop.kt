package lotto.generator

import lotto.domain.LottoTickets
import lotto.generator.ticket.ManualTicketGenerator

class MockLottoShop(private val manualTicketGenerator: ManualTicketGenerator) : LottoShop {
    override fun provideAutoTickets(ticketCount: Int): LottoTickets = LottoTickets(listOf())
    override fun provideManualTickets(manualNumbersList: List<List<Int>>): LottoTickets =
        manualTicketGenerator.create(manualNumbersList)
}
