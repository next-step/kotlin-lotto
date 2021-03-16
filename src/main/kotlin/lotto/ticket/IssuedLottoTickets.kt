package lotto.ticket

import lotto.result.WinningResult

class IssuedLottoTickets(
    private val lottoTickets: List<LottoTicket>
) {

    fun match(winningTicket: WinningTicket): WinningResult {
        val winningSheets = lottoTickets.map { it.match(winningTicket) }
        return WinningResult.aggregate(
            prizeRanks = winningSheets
        )
    }
}