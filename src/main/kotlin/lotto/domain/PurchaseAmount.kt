package lotto.domain

@JvmInline
value class PurchaseAmount(val amount: Int) {
    init {
        require(amount >= 1000) { REQUIRE_MORE_THAN_1000 }
    }

    companion object {
        private const val REQUIRE_MORE_THAN_1000 = "1000원 이상의 금액을 입력해 주세요."
    }
}
