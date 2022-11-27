package lotto.model

import java.lang.NumberFormatException

class WinnerNumber(input: String) {
    val winnerNumbers = generateWinnerNumbers(input)

    private fun generateWinnerNumbers(input: String): List<Int> {
        val numbers = splitInputValue(input).map {
            checkValidNumber(it)
            checkValidRange(it)
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

    private fun checkValidRange(number: String) {
        require(number.toInt() in LOTTO_WINNER_NUMBER_RANGE) { "1에서 45 사이의 값을 입력하세요." }
    }

    companion object {
        const val INPUT_VALUE_DELIMITER = ", "
        val LOTTO_WINNER_NUMBER_RANGE = 1..45
    }
}
