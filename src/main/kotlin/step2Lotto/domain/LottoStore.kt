package step2Lotto.domain

class LottoStore(
    private val lottoGenerator: LottoGenerator
) {
    fun purchaseLottoTickets(purchaseAmount: Int): List<Lotto> {
        require(purchaseAmount >= 1000) { AMOUNT_IS_INSUFFICIENT }

        return List(getLottoTicketQuantity(purchaseAmount)) { lottoGenerator.createLotto() }
    }

    private fun getLottoTicketQuantity(purchaseAmount: Int): Int {
        return purchaseAmount / LOTTO_PRICE
    }

    companion object {
        private const val AMOUNT_IS_INSUFFICIENT = "1000원 이상의 금액을 입력해 주세요"
        private const val LOTTO_PRICE = 1000
    }
}
