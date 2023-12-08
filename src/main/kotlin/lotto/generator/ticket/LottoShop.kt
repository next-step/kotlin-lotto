package lotto.generator.ticket

import lotto.domain.LottoTickets

interface LottoShop {
    fun provideAutoTickets(ticketCount: Int): LottoTickets
    fun provideManualTickets(ticketCount: Int): LottoTickets
}

interface TicketGenerator {
    fun create(ticketCount: Int): LottoTickets
}
