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

        checkNegative(numbers)
        checkNumberSize(numbers)
        checkDuplication(numbers)

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

    private fun checkNegative(numbers: List<Int>) {
        val isPositive = numbers.all {
            it >= 0
        }
        require(isPositive) { "음수 입력 불가" }
    }

    private fun checkNumberSize(numbers: List<Int>) {
        require(numbers.size == 6) { "당첨 번호는 6개여야 합니다." }
    }

    private fun checkDuplication(numbers: List<Int>) {
        require(numbers.toSet().size == LOTTO_NUMBER_SIZE) { "중복 불가" }
    }

    companion object {
        const val INPUT_VALUE_DELIMITER = ", "
        const val LOTTO_NUMBER_SIZE = 6
        val LOTTO_WINNER_NUMBER_RANGE = 1..45
    }
}
