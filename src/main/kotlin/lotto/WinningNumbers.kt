package lotto

class WinningNumbers(private val winningNumbers: List<Int>) {
    fun isContained(lottoNumber: Int): Boolean {
        return winningNumbers.contains(lottoNumber)
    }

    companion object {
        fun getInstance(winningNumbers: String): WinningNumbers {
            val numbers = winningNumbers.replace(" ", "")
                .split(InputView.DELIMITER)
                .map { it.toInt() }
            validateDuplicatedNumber(numbers)
            return WinningNumbers(numbers)
        }

        private fun validateDuplicatedNumber(numbers: List<Int>) {
            if (numbers.distinct().size != numbers.size) {
                throw IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.")
            }
        }
    }
}
