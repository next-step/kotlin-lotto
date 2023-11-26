package lotto2.ui

object LottoInputValidation {
    private const val MIN_PURCHASE_AMOUNT = 1_000
    private const val MIN_QUANTITY = 0

    fun validatePurchaseAmount(amount: Int) {
        require(amount >= MIN_PURCHASE_AMOUNT) {
            "구매금액은 ${MIN_PURCHASE_AMOUNT}원 이상의 숫자를 입력해주세요. 입력한 구매 금액: $amount"
        }
    }

    fun validateManualTicketQuantity(quantity: Int) {
        require(quantity >= MIN_QUANTITY) {
            "수동으로 구매할 로또 수는 $MIN_QUANTITY 이상의 숫자를 입력해주세요. 입력한 수동 로또 구매 수량: $quantity"
        }
    }
}
