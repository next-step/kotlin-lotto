package lotto

class LottoShop(money: Int) {
    private var purchasableCount: Int

    init {
        moneyValidate(money)
        purchasableCount = money / LottoPolicy.LOTTO_PRICE
    }

    fun autoPurchase(purchaseCount: Int = purchasableCount): List<LottoTicket> {
        isPurchasable(purchaseCount)
        return List(purchaseCount) { LottoCreator.autoCreate() }
    }

    fun manualPurchase(manualNumbers: ManualPurchaseNumbers): List<LottoTicket> {
        isPurchasable(manualNumbers.count)
        return manualNumbers.bunchOfNumbers.map(LottoCreator::manualCreate)
    }

    private fun isPurchasable(count: Int) {
        if (purchasableCount < count) {
            throw RuntimeException("구매할 수 있는 이상의 숫자 구매를 요청했습니다. (구매가눙수: $purchasableCount, 요청수:$count")
        }
    }

    private fun moneyValidate(money: Int) {
        if (money < LottoPolicy.LOTTO_PRICE) {
            throw RuntimeException("로또 구매 비용이 부족합니다. - `$money` (최소`${LottoPolicy.LOTTO_PRICE}` 이상 필요)")
        }
    }
}
