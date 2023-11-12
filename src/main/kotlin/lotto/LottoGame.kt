package lotto

class LottoGame(private val purchaseAmount: Int) {
    val ticketQuantity: Int = purchaseAmount / LOTTO_PRICE
    private var lottoTickets: LottoTickets? = null

    init {
        require(purchaseAmount >= 1000) { "구매금액은 1000원 이상이어야 합니다. 입력한 구매 금액: $purchaseAmount" }
    }

    fun start() {
        lottoTickets = LottoTickets(ticketQuantity)
    }

    fun getAllLottoNumbers(): List<List<Int>> {
        return lottoTickets?.getAllLottoNumbers()
            ?: throw IllegalStateException("로또 게임을 아직 시작하지 않았습니다.")
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
