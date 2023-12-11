package lotto.generator.ticket

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets

object ManualTicketGenerator {
    fun create(manualNumbersList: List<List<Int>>): LottoTickets {
        return LottoTickets(
            manualNumbersList.map { list ->
                LottoTicket(list.map { LottoNumber(it) })
            }
        )
    }
}
