package lotto.domain

import lotto.LottoConstants.LOTTO_NUMBERS_SIZE

data class WinningNumbers(private val numbers: LottoNumbers = LottoNumbers()) {
    fun getSumMatchingNumbers(lotto: LottoNumbers): Int {
        var sum = 0
        lotto.value.forEach {
            if (isContain(it)) sum++
        }
        return sum
    }

    private fun isContain(number: Int): Boolean {
        return numbers.value.contains(number)
    }

    companion object {
        private const val INVALID_INPUT_ERROR_MESSAGE = "당첨 번호는 숫자만 입력할 수 있습니다."
        private const val INVALID_VALUE_ERROR_MESSAGE = "당첨 번호는 1 ~ 45 사이의 숫자여야 합니다."
        private const val INVALID_LOTTO_SIZE_ERROR_MESSAGE = "당첨 번호는 6개의 숫자여야 합니다."
        private const val DUPLICATED_NUMBER_ERROR_MESSAGE = "당첨 번호는 중복될 수 없습니다."

        fun from(input: String): WinningNumbers {
            val strings = input.split(", ")
            val numbers = strings.map { verifyValue(it) }

            verifySize(numbers)
            verifyDuplicate(numbers)

            return WinningNumbers(LottoNumbers(numbers))
        }

        private fun verifyValue(value: String): Int {
            val number = value.toIntOrNull() ?: throw IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE)
            if (!CandidateNumbers.isCandidateNumbers(number))
                throw IllegalArgumentException(INVALID_VALUE_ERROR_MESSAGE)
            return number
        }

        private fun verifySize(numbers: List<Int>) {
            if (numbers.size != LOTTO_NUMBERS_SIZE)
                throw IllegalArgumentException(INVALID_LOTTO_SIZE_ERROR_MESSAGE)
        }

        private fun verifyDuplicate(numbers: List<Int>) {
            if (numbers.distinct().size != numbers.size)
                throw IllegalArgumentException(DUPLICATED_NUMBER_ERROR_MESSAGE)
        }
    }
}
