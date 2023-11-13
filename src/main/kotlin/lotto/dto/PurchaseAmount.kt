package lotto.dto

data class PurchaseAmount(val amount: Int) {
    init {
        require(amount > 0) { "구입 금액은 0보다 커야 합니다." }
        require(amount % 1000 == 0) { "구입 금액은 1000원 단위로 입력해야 합니다." }
    }
}
