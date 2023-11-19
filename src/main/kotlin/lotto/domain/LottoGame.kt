package lotto.domain

class LottoGame(
    private var lottoTicketIssuer: LottoTicketIssuer = LottoTicketIssuer(),
) {
    private var _purchaseMoney: Long? = null
    private var _lottoTickets: List<LottoTicket>? = null

    val lottoTickets: List<LottoTicket>
        get() = _lottoTickets ?: throw IllegalStateException("아직 로또를 구매하지 않았습니다.")

    val purchaseMoney: Long
        get() = _purchaseMoney ?: throw IllegalStateException("아직 구입금액을 지불하지 않았습니다.")

    fun purchaseLotto(purchaseMoney: Long) {
        this._purchaseMoney = purchaseMoney
        this._lottoTickets = lottoTicketIssuer.issueLottoByAuto(purchaseMoney)
    }

    fun generateLottoGameResult(winningLottoNumbers: Set<Int>): LottoGameResult {
        return LottoGameResult(
            purchaseMoney = purchaseMoney,
            winningLottoNumbers = winningLottoNumbers,
            lottoTickets = lottoTickets,
        )
    }
}
