package lottery.validator

object InputValidator {
    private const val INVALID_MANUAL_NUMBERS_EXCEPTION = "로또 번호를 유효한 숫자로 입력해주세요."
    private const val INVALID_WINNING_NUMBERS_EXCEPTION = "당첨 번호를 유효한 숫자로 입력해주세요."
    private const val DELIMITER = ","

    fun validateManualNumbers(input: String): String {
        input.split(DELIMITER).map {
            require(it.toIntOrNull() is Int) { INVALID_MANUAL_NUMBERS_EXCEPTION }
            it.toInt()
        }
        return input
    }

    fun validateWinningNumbers(input: String): List<Int> {
        val numbers = input.split(DELIMITER).map {
            require(it.toIntOrNull() is Int) { INVALID_WINNING_NUMBERS_EXCEPTION }
            it.toInt()
        }
        return numbers
    }
}
