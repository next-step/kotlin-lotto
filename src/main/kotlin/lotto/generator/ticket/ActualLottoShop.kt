package lotto.generator.ticket

import lotto.domain.LottoTickets

class ActualLottoShop(
    private val autoTicketGenerator: TicketGenerator,
    private val manualTicketGenerator: TicketGenerator,
) : LottoShop {
    override fun provideAutoTickets(ticketCount: Int): LottoTickets = autoTicketGenerator.create(ticketCount)
    override fun provideManualTickets(ticketCount: Int): LottoTickets = manualTicketGenerator.create(ticketCount)
}
