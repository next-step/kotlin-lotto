package lotto.domain

@JvmInline
value class PurchaseAmount(private val amount: Int) {
    init {
        require(amount >= LOTTO_PRICE) { INVALID_VALUE_ERROR_MESSAGE }
    }

    fun getAmount() = amount
    fun getNumberOfLotto() = amount / LOTTO_PRICE

    companion object {
        private const val LOTTO_PRICE = 1000
        private const val INVALID_VALUE_ERROR_MESSAGE = "구입 금액은 $LOTTO_PRICE 원 이상이어야 합니다."
    }
}
