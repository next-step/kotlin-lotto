package lotto.domain

object LottoStore {
    val LOTTO_PRICE = LottoPrice(1000)

    fun purchaseAuto(amount: PurchaseAmount, shuffleStrategy: (List<LottoNumber>) -> List<LottoNumber>): LottoTickets {
        val count = amount / LOTTO_PRICE
        return LottoTickets.create(count, shuffleStrategy)
    }

    fun purchaseManual(manualCount: ManualCount, purchase: () -> List<LottoNumber>): LottoTickets {
        return LottoTickets((1..manualCount.count).map { LottoTicket(purchase.invoke().toSet()) })
    }
}
