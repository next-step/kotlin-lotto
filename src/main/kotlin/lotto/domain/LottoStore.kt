package lotto.domain

class LottoStore(
    private val lottoGenerator: LottoGenerator
) {
    fun purchaseLottoTickets(purchaseAmount: PurchaseAmount): List<Lotto> {
        return List(getLottoTicketQuantity(purchaseAmount.amount)) { lottoGenerator.createLotto() }
    }

    private fun getLottoTicketQuantity(purchaseAmount: Int): Int {
        return purchaseAmount / LOTTO_PRICE
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
