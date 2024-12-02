package lotto.core

import lotto.core.constant.LottoConstants

class LottoPurchaseCount(val autoLottoCount: Int, val manualLottoCount: Int) {
    constructor(
        purchaseAmount: String,
        manualLottoCount: Int,
    ) : this((calculatePurchasableCount(purchaseAmount) - manualLottoCount), manualLottoCount)

    companion object {
        private fun calculatePurchasableCount(purchaseAmount: String): Int {
            val amount = purchaseAmount.toIntOrNull() ?: throw NumberFormatException("잘못된 금액이 입력되었습니다.")
            require(amount > 0) { "잘못된 금액이 입력되었습니다." }
            return amount / LottoConstants.LOTTO_PRICE
        }
    }
}
