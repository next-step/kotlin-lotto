package lotto.generator

import lotto.domain.LottoTickets
import lotto.generator.ticket.AutoTicketGenerator
import lotto.generator.ticket.ManualTicketGenerator

class ActualLottoShop(
    private val autoTicketGenerator: AutoTicketGenerator,
    private val manualTicketGenerator: ManualTicketGenerator,
) : LottoShop {
    override fun provideAutoTickets(ticketCount: Int, preGeneratedTicketCount: Int): LottoTickets = autoTicketGenerator.create(ticketCount - preGeneratedTicketCount)
    override fun provideManualTickets(manualNumbersList: List<List<Int>>): LottoTickets =
        manualTicketGenerator.create(manualNumbersList)
}
