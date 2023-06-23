package step2Lotto.domain

class LottoService {
    fun getLottoTicketQuantity(purchaseAmount: Int): Int {
        return purchaseAmount / LOTTO_PRICE
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}