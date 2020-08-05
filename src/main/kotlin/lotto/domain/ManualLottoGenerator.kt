package lotto.domain

import lotto.domain.LottoGenerator.Companion.COUNT
import lotto.domain.LottoGenerator.Companion.MAX
import lotto.domain.LottoGenerator.Companion.MIN

class ManualLottoGenerator(private val numbers: String) : LottoGenerator {

    override fun execute() = parseNumbers(numbers).map { it.trim().toInt() }

    companion object {
        private const val NUMBER_DELIMITER = ","

        fun isAcceptable(numbers: String): Boolean {
            val parsedNumbers = parseNumbers(numbers)
            return parsedNumbers.all { isValidNumber(it) } && isValidSize(parsedNumbers)
        }

        private fun parseNumbers(numbers: String) = numbers.split(NUMBER_DELIMITER)

        private fun isValidNumber(number: String): Boolean {
            val numberToInt = number.trim().toIntOrNull()
            return numberToInt != null && numberToInt in (MIN..MAX)
        }

        private fun isValidSize(parsedNumbers: List<String>): Boolean =
            parsedNumbers.size == COUNT && parsedNumbers.size == parsedNumbers.distinct().size
    }
}
