package lotto.core

import lotto.core.constant.LottoConstants

data class WinningNumbers(val winningNumbers: List<Int>) {
    constructor(winningNumbers: String?) : this(splitNumbers(winningNumbers))

    companion object {
        private fun splitNumbers(winningNumbers: String?): List<Int> {
            if (winningNumbers == null) {
                throw RuntimeException()
            }

            val numberList = winningNumbers.split(DELIMITER)
            if (numberList.size < LottoConstants.LOTTO_NUMBER_COUNT) {
                throw RuntimeException()
            }

            val numbers = transformNumbers(numberList)
            checkInsideLottoNumber(numbers)
            checkDuplicates(numbers)
            return numbers
        }

        private fun transformNumbers(numberList: List<String>): List<Int> {
            return numberList.map { number -> number.trim().toIntOrNull() ?: throw RuntimeException() }
        }

        private fun checkDuplicates(list: List<Int>) {
            if (list.size != list.toSet().size) {
                throw RuntimeException()
            }
        }

        private fun checkInsideLottoNumber(numbers: List<Int>) {
            numbers.forEach {
                if (it < LottoConstants.LOTTO_NUMBER_MIN || LottoConstants.LOTTO_NUMBER_MAX < it) {
                    throw RuntimeException()
                }
            }
        }

        private const val DELIMITER = ","
    }
}
