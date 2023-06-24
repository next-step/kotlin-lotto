package step2Lotto.domain

class LottoService(
    private val lottoGenerator: LottoGenerator
) {
    fun getLottoTicketQuantity(purchaseAmount: Int): Int {
        return purchaseAmount / LOTTO_PRICE
    }

    fun purchaseLottoTickets(lottoTicketQuantity: Int): List<Lotto> {
        return List(lottoTicketQuantity) { lottoGenerator.execute() }
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
