package lotto.domain.ticket

import lotto.domain.result.LottoResult

class LottoTickets(
    val tickets: List<LottoTicket>
) {
    fun compare(winningTicket: WinningLottoTicket): LottoResult {
        val result = LottoResult()
        tickets.forEach {
            val winningBoard = winningTicket.compare(it)
            result.add(winningBoard)
        }
        return result
    }
}
