package lotto.domain

@JvmInline
value class LottoPurchaseCount(val count: Int) {
    init {
        checkIsNaturalNumber()
    }

    private fun checkIsNaturalNumber() {
        require(count > 0) { "로또 구매 개수는 1 이상이어야 합니다." }
    }
}
