package lotto.domain

import lotto.Rank

class LottoResult(
    private val winningLottoTicket: WinningLottoTicket,
    private val lottoTickets: LottoTickets,
) {
    fun getStatics(): Map<Rank, Int> {
        return lottoTickets.tickets.map { lottoTicket ->
            winningLottoTicket.match(lottoTicket)
        }.groupingBy { it }
            .eachCount()
    }
}
