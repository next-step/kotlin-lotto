package lotto.domain

object LottoStore {
    val LOTTO_PRICE = LottoPrice(1000)

    fun purchase(
        amount: PurchaseAmount,
        manualCount: LottoCount,
        shuffleStrategy: (List<LottoNumber>) -> List<LottoNumber>,
        manualPurchaser: () -> List<LottoNumber>
    ): LottoTickets {
        val purchaseCount = amount / LOTTO_PRICE
        val manual = purchaseManual(manualCount, manualPurchaser)
        val auto = purchaseAuto(purchaseCount - manualCount, shuffleStrategy)
        return LottoTickets(manual + auto)
    }

    fun purchaseAuto(count: LottoCount, shuffleStrategy: (List<LottoNumber>) -> List<LottoNumber>): List<LottoTicket> {
        return count.repeat { LottoTicket.create(shuffleStrategy) }
    }

    fun purchaseManual(manualCount: LottoCount, manualPurchaser: () -> List<LottoNumber>): List<LottoTicket> {
        return manualCount.repeat { LottoTicket(manualPurchaser().toSet()) }
    }
}
