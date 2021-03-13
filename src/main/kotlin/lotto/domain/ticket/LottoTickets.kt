package lotto.domain.ticket

import lotto.domain.result.LottoResult

class LottoTickets(
    val tickets: List<LottoTicket>
) {
    fun compare(winningLotto: WinningLotto): LottoResult {
        val result = LottoResult()
        tickets.forEach {
            val winningBoard = winningLotto.compare(it)
            result.add(winningBoard)
        }
        return result
    }
}
