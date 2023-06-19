package lotto.domain

data class PurchaseAmount(val amount: Int) {
    init {
        require(amount % 1000 == 0) { "로또 가격은 장당 1,000 입니다. 금액에 맞게 요금을 입력해 주세요." }
    }
}
