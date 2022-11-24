package lotto.domain

@JvmInline
value class PurchaseAmount(private val _amount: Double) {
    private val amount: Double
        get() = _amount

    companion object {
        private const val INVALID_INPUT_ERROR_MESSAGE = "구입 금액은 숫자여야 합니다."

        fun from(input: String): PurchaseAmount {
            val amount = input.toDoubleOrNull()
                ?: throw IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE)
            return PurchaseAmount(amount)
        }
    }
}
