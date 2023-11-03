package lottery.validator

object InputValidator {
    private const val INVALID_PURCHASE_AMOUNT_EXCEPTION = "구입 금액은 숫자로 입력해주세요."

    fun validateAmount(amount: String): Int =
        amount.toIntOrNull() ?: throw IllegalArgumentException(INVALID_PURCHASE_AMOUNT_EXCEPTION)
}
