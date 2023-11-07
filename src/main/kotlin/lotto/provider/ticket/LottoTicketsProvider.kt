package lotto.provider.ticket

import lotto.domain.LottoTickets

abstract class LottoTicketsProvider {
    abstract fun provideLottoTickets(ticketCount: Int): LottoTickets

    fun provideLottoPrice() = 1000
}
