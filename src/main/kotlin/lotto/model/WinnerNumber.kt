package lotto.model

class WinnerNumber(input: String) {
    val winnerNumbers = generateWinnerNumbers(input)

    private fun generateWinnerNumbers(input: String): List<Int> {
        val numbers = splitInputValue(input).map {
            LottoNumber(it)
        }

        checkNumberSize(numbers)
        checkDuplication(numbers)
        return numbers.map { it.number }
    }

    private fun splitInputValue(input: String): List<String> {
        return input.split(INPUT_VALUE_DELIMITER)
    }

    private fun checkNumberSize(numbers: List<LottoNumber>) {
        require(numbers.size == 6) { "당첨 번호는 6개여야 합니다." }
    }

    private fun checkDuplication(numbers: List<LottoNumber>) {
        require(numbers.toSet().size == LottoNumber.LOTTO_NUMBER_SIZE) { "중복 불가" }
    }

    companion object {
        const val INPUT_VALUE_DELIMITER = ", "
    }
}
