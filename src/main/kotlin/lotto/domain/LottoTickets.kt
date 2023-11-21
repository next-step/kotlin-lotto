package lotto.domain

import lotto.domain.vo.RankFrequency
import lotto.presentation.controller.LottoResult

class LottoTickets(val tickets: List<LottoTicket>) {
    fun aggregateByRank(winningLottoInfo: WinningLottoInfo): LottoResult =
        winningLottoInfo.aggregateByRank(tickets)

    fun size(): Int = tickets.size

    companion object {
        fun of(tickets: List<LottoTicket>): LottoTickets = LottoTickets(tickets)
    }
}
