package lotto.provider.ticket

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets

object AutoTicketProvideStrategy : TicketProvideStrategy {
    private val preGeneratedLottoNumbers = (LottoNumber.validNumberRange)
        .map { LottoNumber(it) }
    override fun provide(ticketCount: Int): LottoTickets {
        val tickets = List(ticketCount) {
            LottoTicket(
                preGeneratedLottoNumbers
                    .toMutableList()
                    .shuffled()
                    .subList(0, 6)
            )
        }

        return LottoTickets(tickets)
    }
}
