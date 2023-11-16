package lotto.domain

import lotto.provider.ticket.TicketProvideStrategy

object AutoTicketProvideStrategy : TicketProvideStrategy {
    private val preGeneratedLottoNumbers = (LottoNumber.validNumberRange)
        .map { LottoNumber(it) }
    override fun provide(ticketCount: Int): LottoTickets {
        val tickets = mutableListOf<LottoTicket>()

        while (tickets.size != ticketCount) {
            val ticket = LottoTicket(
                preGeneratedLottoNumbers
                    .toMutableList()
                    .shuffled()
                    .subList(0, 6)
            )
            tickets.add(ticket)
        }

        return LottoTickets(tickets)
    }
}
