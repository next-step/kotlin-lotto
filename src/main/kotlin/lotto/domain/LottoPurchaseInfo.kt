package lotto.domain

class LottoPurchaseInfo(val purchaseCount: LottoPurchaseCount, val purchaseAmount: LottoPurchaseAmount) {
    companion object {
        fun from(purchaseAmount: LottoPurchaseAmount): LottoPurchaseInfo {
            return LottoPurchaseInfo(LottoPurchaseCount.from(purchaseAmount), purchaseAmount)
        }
    }
}
