package lotto.domain

@JvmInline
value class PurchaseAmount(val amount: Int) {
    init {
        require(amount > 1000) { println("1000원 이상의 금액을 입력해 주세요") }
    }
}
