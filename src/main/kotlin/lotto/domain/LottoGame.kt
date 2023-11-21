package lotto.domain

class LottoGame(
    val purchaseMoney: Long,
    lottoTicketIssuer: LottoTicketIssuer = LottoTicketIssuer(),
) {
    var lottoTickets: List<LottoTicket> = lottoTicketIssuer.issueLottoByAuto(purchaseMoney)

    fun generateLottoGameResult(winningLottoNumbers: LottoNumbers): LottoGameResult {
        return LottoGameResult(
            purchaseMoney = purchaseMoney,
            winningLottoNumbers = winningLottoNumbers,
            lottoTickets = lottoTickets,
        )
    }
}
