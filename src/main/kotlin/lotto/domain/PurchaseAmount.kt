package lotto.domain

@JvmInline
value class PurchaseAmount(private val _amount: Double) {
    val amount: Double
        get() = _amount

    init {
        require(_amount % LOTTO_PRICE == ZERO) { INVALID_VALUE_ERROR_MESSAGE }
    }

    companion object {
        private const val INVALID_INPUT_ERROR_MESSAGE = "구입 금액은 숫자여야 합니다."
        private const val INVALID_VALUE_ERROR_MESSAGE = "구입 금액은 1000원 단위만 가능합니다."

        private const val LOTTO_PRICE = 1000.00
        private const val ZERO = 0.00

        fun from(input: String): PurchaseAmount {
            val amount = input.toDoubleOrNull()
                ?: throw IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE)
            return PurchaseAmount(amount)
        }
    }
}
