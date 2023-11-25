package lotto.domain

class LottoGame(
    val purchaseMoney: Long,
    lottoTicketIssuer: LottoTicketIssuer = LottoTicketIssuer(),
) {
    val lottoTickets: List<LottoTicket> = lottoTicketIssuer.issueLottoByAuto(purchaseMoney)

    fun generateLottoGameResult(winningLottoNumbers: WinningLottoNumbers): LottoGameResult {
        return LottoGameResult(
            purchaseMoney = purchaseMoney,
            winningLottoNumbers = winningLottoNumbers,
            lottoTickets = lottoTickets,
        )
    }
}
