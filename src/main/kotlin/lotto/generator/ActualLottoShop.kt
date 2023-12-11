package lotto.generator

import lotto.domain.LottoTickets
import lotto.generator.ticket.AutoTicketGenerator
import lotto.generator.ticket.ManualTicketGenerator

class ActualLottoShop(
    private val autoTicketGenerator: AutoTicketGenerator,
    private val manualTicketGenerator: ManualTicketGenerator,
) : LottoShop {
    override fun provideAutoTickets(ticketCount: Int): LottoTickets = autoTicketGenerator.create(ticketCount)
    override fun provideManualTickets(manualNumbersList: List<List<Int>>): LottoTickets =
        manualTicketGenerator.create(manualNumbersList)
}
