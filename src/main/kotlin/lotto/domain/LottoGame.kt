package lotto.domain

import lotto.dto.LottoResults


class LottoGame(
    val lottoTickets: List<LottoTicket>,
    val winnerTicket: WinnerTicket
) {
    fun pickWinnerTickets(): LottoResults {
        return LottoResults(
            winnings = lottoTickets.map { winnerTicket.drawResult(it) }
                .filter { it.isWinning() },
            purchaseCount = lottoTickets.size
        )
    }


}