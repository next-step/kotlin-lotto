package lotto.application.vo

private const val LOTTO_PRICE = 1000

class Purchase(
    amount: Long,
    manualLottoCount: Int
) {
    val amount: Amount
    val purchaseCounts: PurchaseCounts

    init {
        require(manualLottoCount * LOTTO_PRICE <= amount) { "수동 로또 갯수가 구입 금액보다 클수 없습니다." }

        val autoLottoCount: Int = ((amount - manualLottoCount * LOTTO_PRICE) / LOTTO_PRICE).toInt()
        purchaseCounts = PurchaseCounts(PurchaseCount(autoLottoCount), PurchaseCount(manualLottoCount))
        this.amount = Amount(amount)
    }
}
