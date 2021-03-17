package lotto.ticket

import lotto.result.WinningResult

class IssuedLottoTickets(
    val lottoTickets: List<LottoTicket>
) {

    fun match(winningTicket: WinningTicket): WinningResult {
        val prizes = lottoTickets.map { it.match(winningTicket) }
        return WinningResult.aggregate(
            ranks = prizes
        )
    }
}
