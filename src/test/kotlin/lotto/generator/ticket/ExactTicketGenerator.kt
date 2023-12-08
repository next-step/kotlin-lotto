package lotto.generator.ticket

import lotto.domain.LottoTickets

class ExactTicketGenerator(private val lottoTickets: LottoTickets) : TicketGenerator {
    override fun create(ticketCount: Int): LottoTickets = lottoTickets
}
