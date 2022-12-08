package lotto.domain

@JvmInline
value class PurchaseAmount(private val amount: Int) {
    init {
        require(amount >= 0) { INVALID_VALUE_ERROR_MESSAGE }
    }

    fun getAmount() = amount
    fun getNumberOfLotto() = amount / LOTTO_PRICE

    companion object {
        private const val LOTTO_PRICE = 1000
        private const val INVALID_VALUE_ERROR_MESSAGE = "올바른 구입 금액을 입력해 주세요."
    }
}
