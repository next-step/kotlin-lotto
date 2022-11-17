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

    operator fun plus(lottoTicketBulk: LottoTicketBulk): LottoTicketBulk {
        return LottoTicketBulk(lottoTickets + lottoTicketBulk.lottoTickets)
    }
    companion object {
        fun of(lottoTickets: List<Set<Int>>): LottoTicketBulk {
            return LottoTicketBulk(lottoTickets.map { LottoTicket.of(it) })
        }
    }
}
