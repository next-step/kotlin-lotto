package lotto.domain

object LottoStore {
    val LOTTO_PRICE = LottoPrice(1000)

    fun purchaseAuto(
        amount: PurchaseAmount,
        manualCount: LottoCount,
        shuffleStrategy: (List<LottoNumber>) -> List<LottoNumber>
    ): LottoTickets {
        val autoCount = amount / LOTTO_PRICE
        return LottoTickets.create(autoCount - manualCount, shuffleStrategy)
    }

    fun purchaseManual(manualCount: LottoCount, purchase: () -> List<LottoNumber>): LottoTickets {
        return LottoTickets(manualCount.repeat { LottoTicket(purchase.invoke().toSet()) })
    }
}
