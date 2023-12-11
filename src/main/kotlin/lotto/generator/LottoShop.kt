package lotto.generator

import lotto.domain.LottoTickets

interface LottoShop {
    fun provideAutoTickets(ticketCount: Int, preGeneratedTicketCount: Int): LottoTickets
    fun provideManualTickets(manualNumbersList: List<List<Int>>): LottoTickets
}
