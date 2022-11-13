package lotto


class LottoGame(
    val lottoTickets: List<LottoTicket>,
    val winnerTicket: WinnerTicket
) {
    fun pickWinnerTickets(): LottoResults {
        return LottoResults(
            winnings = lottoTickets.map { winnerTicket.drawResult(it) }
                .filter { it.matchCount >= 3 },
            purchaseCount = lottoTickets.size
        )
    }


}