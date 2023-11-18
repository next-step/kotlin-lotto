package lotto2.ui

object LottoInputValidation {
    private const val MIN_PURCHASE_AMOUNT = 1000

    fun validatePurchaseAmount(amount: Int) {
        require(amount >= MIN_PURCHASE_AMOUNT) {
            "구매금액은 ${MIN_PURCHASE_AMOUNT}원 이상이어야 합니다. 입력한 구매 금액: $amount"
        }
    }
}
