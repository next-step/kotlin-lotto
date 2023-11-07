package lotto.provider.ticket

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets

abstract class LottoTicketsProvider(protected val ticketProvideStrategy: TicketProvideStrategy) {
    abstract fun provide(ticketCount: Int): LottoTickets

    fun provideLottoPrice() = 1000
}

interface TicketProvideStrategy {
    fun provide(ticketCount: Int): LottoTickets
}

object AutoTicketProvideStrategy : TicketProvideStrategy {
    override fun provide(ticketCount: Int): LottoTickets {
        val tickets = mutableListOf<LottoTicket>()

        while (tickets.size != ticketCount) {
            val ticket = LottoTicket(
                (1..45)
                    .toMutableList()
                    .shuffled()
                    .subList(0, 6)
                    .map { LottoNumber(it) }
            )
            tickets.add(ticket)
        }

        return LottoTickets(tickets)
    }
}

class ManualTicketProvideStrategy(private val lottoTickets: LottoTickets) : TicketProvideStrategy {
    override fun provide(ticketCount: Int): LottoTickets = lottoTickets
}
