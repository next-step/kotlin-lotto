package lotto.generator

import lotto.domain.LottoTickets

interface LottoShop {
    fun provideAutoTickets(ticketCount: Int): LottoTickets
    fun provideManualTickets(manualNumbersList: List<List<Int>>): LottoTickets
}
