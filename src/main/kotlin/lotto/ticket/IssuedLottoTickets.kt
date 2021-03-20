package lotto.ticket

import lotto.result.WinningResult

class IssuedLottoTickets(
    val lottoTickets: List<LottoTicket>
) {

    fun match(winningTicket: WinningTicket) = WinningResult.aggregate(
        ranks = lottoTickets.map {
            winningTicket.match(it)
        }
    )
}
