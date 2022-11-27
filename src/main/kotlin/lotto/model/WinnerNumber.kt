package lotto.model

import java.lang.NumberFormatException

class WinnerNumber(input: String) {
    val winnerNumbers = generateWinnerNumbers(input)

    private fun generateWinnerNumbers(input: String): List<Int> {
        val numbers = splitInputValue(input).map {
            checkValidNumber(it)
            it.toInt()
        }.toList()

        return numbers
    }

    private fun splitInputValue(input: String): List<String> {
        return input.split(INPUT_VALUE_DELIMITER)
    }

    private fun checkValidNumber(number: String) {
        try {
            number.toInt()
        } catch (error: NumberFormatException) {
            throw IllegalArgumentException("숫자만 입력 가능합니다.")
        }
    }

    companion object {
        const val INPUT_VALUE_DELIMITER = ", "
    }
}
