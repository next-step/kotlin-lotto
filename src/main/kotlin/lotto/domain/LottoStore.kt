package lotto.domain

object LottoStore {
    val LOTTO_PRICE = LottoPrice(1000)

    fun purchase(amount: String, shuffleStrategy: (List<LottoNumber>) -> List<LottoNumber>): LottoTickets {
        val count = PurchaseAmount(amount) / LOTTO_PRICE
        return LottoTickets.create(count, shuffleStrategy)
    }
}
