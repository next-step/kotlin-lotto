package lotto.ui

import lotto.domain.ExceptionType.INPUT_MUST_NOT_NULL
import lotto.domain.ExceptionType.INPUT_MUST_UNSIGNED_INT
import lotto.domain.ExceptionType.LAST_WEEK_NUMBERS_MUST_IN_RANGE

object InputView {
    private val unsignedNumberRegex = "\\d*".toRegex()
    private const val delimiter = ","
    private val numberRange = (1..45)

    fun readInputForLottoGameBudget(): Int {
        val budgetInput = readLine()
        requireNotNull(budgetInput) { INPUT_MUST_NOT_NULL }
        require(isUnsignedInt(budgetInput)) { INPUT_MUST_UNSIGNED_INT }
        return budgetInput.toInt()
    }

    fun readInputForLastWeekNumbers(): List<Int> {
        val numbersInput = readLine()
        requireNotNull(numbersInput) { INPUT_MUST_NOT_NULL }
        val numbersInString = numbersInput.split(delimiter)
        numbersInString.forEach { require(isUnsignedInt(it)) { INPUT_MUST_UNSIGNED_INT } }
        val numbers = numbersInString.map { it.toInt() }
        numbers.forEach { isValidatedLastWeekNumber(it) }
        return numbers
    }

    fun readInputForLastWeekBonusNumbers(): Int {
        val numbersInput = readLine()
        requireNotNull(numbersInput) { INPUT_MUST_NOT_NULL }
        require(isUnsignedInt(numbersInput)) { INPUT_MUST_UNSIGNED_INT }
        val number = numbersInput.toInt()
        isValidatedLastWeekNumber(number)
        return number
    }

    private fun isUnsignedInt(numberOfString: String) = numberOfString.matches(unsignedNumberRegex)

    private fun isValidatedLastWeekNumber(number: Int) {
        require(numberRange.contains(number)) { LAST_WEEK_NUMBERS_MUST_IN_RANGE }
    }
}
