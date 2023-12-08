package lotto.generator.ticket

import lotto.domain.LottoTickets

object ActualLottoShop : LottoShop {
    override fun provideAutoTickets(ticketCount: Int): LottoTickets = AutoTicketGenerator.provide(ticketCount)
    override fun provideManualTickets(ticketCount: Int): LottoTickets = ManualTicketGenerator.provide(ticketCount)
}
