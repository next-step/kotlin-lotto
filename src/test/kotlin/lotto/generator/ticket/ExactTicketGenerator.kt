package lotto.generator.ticket

import lotto.domain.LottoTickets

class ExactTicketGenerator(private val lottoTickets: LottoTickets) : TicketGenerator {
    override fun provide(ticketCount: Int): LottoTickets = lottoTickets
}
