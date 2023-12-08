package lotto.provider.ticket

import lotto.domain.LottoTickets

interface LottoShop {
    fun provideAutoTickets(ticketCount: Int): LottoTickets
    fun provideManualTickets(ticketCount: Int): LottoTickets
}

interface TicketProvideStrategy {
    fun provide(ticketCount: Int): LottoTickets
}
