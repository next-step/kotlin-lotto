package lotto.domain

data class LottoPurchaseAmount(
    val amount: Int,
) {
    init {
        amount.validateMinimum()
        amount.validatePurchaseMinUnit()
    }

    private fun Int.validateMinimum() {
        require(this >= MIN_PURCHASE_AMOUNT) {
            "[PurchaseAmount] 구매금액은 ${MIN_PURCHASE_AMOUNT}원 이상이어야 합니다. | 입력금액: $this"
        }
    }

    private fun Int.validatePurchaseMinUnit() {
        require(this % MIN_PURCHASE_AMOUNT == 0) {
            "[PurchaseAmount] 구매금액은 ${MIN_PURCHASE_AMOUNT}원 단위이어야 합니다. | 입력금액: $this"
        }
    }

    companion object {
        private const val MIN_PURCHASE_AMOUNT = 1000
    }
}
