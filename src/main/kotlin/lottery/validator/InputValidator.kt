package lottery.validator

object InputValidator {
    private const val INVALID_PURCHASE_AMOUNT_EXCEPTION = "구입 금액은 숫자로 입력해주세요."
    private const val INVALID_WINNING_NUMBERS_EXCEPTION = "당첨 번호를 유효한 숫자로 입력해주세요."
    private const val DELIMITER = ","

    fun validateAmount(amount: String): Int =
        amount.toIntOrNull() ?: throw IllegalArgumentException(INVALID_PURCHASE_AMOUNT_EXCEPTION)

    fun validateWinningNumbers(input: String): List<Int> {
        val numbers = input.split(DELIMITER).map { it.trim().toIntOrNull() ?: throw IllegalArgumentException(INVALID_WINNING_NUMBERS_EXCEPTION) }
        numbers.forEach { validateNumberRange(it) }
        return numbers
    }

    private fun validateNumberRange(number: Int) {
        if (number <= 0) throw IllegalArgumentException(INVALID_WINNING_NUMBERS_EXCEPTION)
    }
}
