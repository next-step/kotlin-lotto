package lotto.domain

import lotto.dto.LottoResult

class LottoTicketBulk(
    val lottoTickets: List<LottoTicket>
) {
    fun checkResult(winnerTicket: WinnerTicket): List<LottoResult> {
        return lottoTickets.map { winnerTicket.drawResult(it) }
            .filter { it.isWinning() }
    }

    fun size() = lottoTickets.size

    companion object {
        fun of(lottoNumbers: List<Set<Int>>): LottoTicketBulk {
            return LottoTicketBulk(lottoNumbers.map {
                LottoTicket.of(it)
            })
        }
    }
}
