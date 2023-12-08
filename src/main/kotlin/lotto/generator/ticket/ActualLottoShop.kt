package lotto.generator.ticket

import lotto.domain.LottoTickets

object ActualLottoShop : LottoShop {
    override fun provideAutoTickets(ticketCount: Int): LottoTickets = AutoTicketGenerator.create(ticketCount)
    override fun provideManualTickets(ticketCount: Int): LottoTickets = ManualTicketGenerator.create(ticketCount)
}
