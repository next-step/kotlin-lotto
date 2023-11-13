package lotto

class LottoGame(private val purchaseAmount: Int) {
    val ticketQuantity: Int = purchaseAmount / LOTTO_PRICE
    private val lottoTickets: LottoTickets

    init {
        require(purchaseAmount >= 1000) { "구매금액은 1000원 이상이어야 합니다. 입력한 구매 금액: $purchaseAmount" }
        lottoTickets = LottoTickets(ticketQuantity)
    }

    fun getAllLottoNumbers(): List<List<Int>> {
        return lottoTickets.getAllLottoNumbers()
    }

    fun checkAllTicketResults(winningLotto: WinningLotto): LottoResultAnalytics {
        return LottoResultAnalytics(winningLotto, lottoTickets)
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
