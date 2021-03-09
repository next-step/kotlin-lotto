package lotto.domain.ticket

import lotto.domain.LottoNumber

class WinningLottoTicket(
    val numbers: List<LottoNumber>
) {
    fun compare(ticket: LottoTicket): WinningBoard {
        val matchNumbers = mutableListOf<LottoNumber>()
        numbers.forEach {
            ticket.fillMatchNumber(matchNumbers, it)
        }
        return WinningBoard.findBy(matchNumbers.size)
    }
}
