package lotto.provider.ticket

import lotto.domain.LottoTickets

object ActualLottoShop : LottoShop {
    override fun provideAutoTickets(ticketCount: Int): LottoTickets = AutoTicketProvideStrategy.provide(ticketCount)
    override fun provideManualTickets(ticketCount: Int): LottoTickets = ManualTicketProvideStrategy.provide(ticketCount)
}
