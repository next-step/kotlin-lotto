package lotto.provider.ticket

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets

object ManualTicketProvideStrategy : TicketProvideStrategy {
    override fun provide(ticketCount: Int): LottoTickets {
        val lottoTicketList = mutableListOf<LottoTicket>()
        repeat(ticketCount) {
            val lottoTicket = LottoTicket(readln().trim().split(",").map { it.toInt() }.map { LottoNumber(it) })
            lottoTicketList.add(lottoTicket)
        }
        return LottoTickets(lottoTicketList)
    }
}
