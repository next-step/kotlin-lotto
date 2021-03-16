package lotto.domain.ticket

import lotto.domain.result.LottoResult

class LottoTickets(
    val tickets: List<LottoTicket>
) {
    fun compare(winningLotto: WinningLotto): LottoResult {
        val winningBoards = tickets.map {
            winningLotto.compare(it)
        }
        return LottoResult(winningBoards)
    }
}
