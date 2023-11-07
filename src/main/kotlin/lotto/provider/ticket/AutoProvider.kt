package lotto.provider.ticket

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets

object AutoProvider : LottoTicketsProvider() {
    override fun provideLottoTickets(ticketCount: Int): LottoTickets {
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
