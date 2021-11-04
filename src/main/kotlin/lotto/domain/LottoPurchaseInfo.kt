package lotto.domain

data class LottoPurchaseInfo(
    val purchaseCount: LottoPurchaseCount,
    val manualPurchaseCount: LottoPurchaseCount,
    val purchaseAmount: LottoPurchaseAmount
) {
    val automaticPurchaseCount: LottoPurchaseCount = LottoPurchaseCount(purchaseCount.value - manualPurchaseCount.value)

    init {
        require(purchaseCount >= manualPurchaseCount) { WRONG_MANUAL_PURCHASE_COUNT }
    }

    companion object {
        const val WRONG_MANUAL_PURCHASE_COUNT = "잘못된 수동 구매 개수입니다."

        fun from(purchaseAmount: LottoPurchaseAmount, manualPurchaseCount: LottoPurchaseCount): LottoPurchaseInfo {
            val purchaseCount = LottoPurchaseCount.from(purchaseAmount)
            return LottoPurchaseInfo(purchaseCount, manualPurchaseCount, purchaseAmount)
        }
    }
}
