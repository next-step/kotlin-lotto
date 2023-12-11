package lotto.generator.ticket

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets

object AutoTicketGenerator {
    private val preGeneratedLottoNumbers = (LottoNumber.validNumberRange)
        .map { LottoNumber(it) }

    fun create(ticketCount: Int): LottoTickets {
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
