package lotto.domain

class LottoStore {
    fun purchase(amount: String): LottoTickets {
        val count = PurchaseAmount(amount).amount / LOTTO_PRICE
        return LottoTickets.create(count)
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
