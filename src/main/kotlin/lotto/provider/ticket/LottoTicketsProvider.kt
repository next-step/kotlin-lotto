package lotto.provider.ticket

import lotto.domain.LottoTickets

interface LottoTicketsProvider {
    fun provideLottoTickets(ticketCount: Int): LottoTickets

    fun provideLottoPrice(): Int
}
