package lotto.dto

data class PurchaseAmount(val amount: Int) {
    init {
        require(amount >= 0) { "금액은 음수일 수 없습니다." }
    }
}
