package lotto

class LottoShop(money: Int) {
    private var purchasableCount: Int

    init {
        moneyValidate(money)
        purchasableCount = money / LOTTO_PRICE
    }

    fun autoPurchase(purchaseCount: Int = purchasableCount): List<LottoTicket> {
        isPurchasable(purchaseCount)
            .also { decreasePurchasableCount(purchaseCount) }
        return LottoCreator.autoCreate(purchaseCount)
    }

    fun manualPurchase(manualNumbers: ManualPurchaseNumbers): List<LottoTicket> {
        isPurchasable(manualNumbers.count)
            .also { decreasePurchasableCount(manualNumbers.count) }
        return manualNumbers.bunchOfNumbers
            .map { it }
    }

    private fun decreasePurchasableCount(count: Int) {
        purchasableCount -= count
    }

    private fun isPurchasable(count: Int) {
        if (purchasableCount < count) {
            throw RuntimeException("구매할 수 있는 이상의 숫자 구매를 요청했습니다. (구매가눙수: $purchasableCount, 요청수:$count")
        }
    }

    private fun moneyValidate(money: Int) {
        if (money < LOTTO_PRICE) {
            throw RuntimeException("로또 구매 비용이 부족합니다. - `$money` (최소`$LOTTO_PRICE` 이상 필요)")
        }
    }

    companion object {
        const val LOTTO_PRICE = 1_000
    }
}
