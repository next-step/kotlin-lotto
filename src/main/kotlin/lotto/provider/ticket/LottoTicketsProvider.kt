package lotto.provider.ticket

import lotto.domain.LottoTickets

abstract class LottoTicketsProvider(protected val ticketProvideStrategy: TicketProvideStrategy) {
    abstract fun provide(ticketCount: Int): LottoTickets
}

interface TicketProvideStrategy {
    fun provide(ticketCount: Int): LottoTickets
}
