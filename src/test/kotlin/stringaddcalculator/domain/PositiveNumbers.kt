package stringaddcalculator.domain

import stringaddcalculator.util.StringUtils

class PositiveNumbers(text: String?) {
    private val positiveNumbers: List<PositiveNumber>

    init {
        val splitData: String = when {
            text.isNullOrBlank() -> DEFAULT_DATA
            else -> text
        }
        positiveNumbers = StringUtils.splitCustomDelimiterOrDefaultDelimiter(splitData)
    }

    fun sum(): Int {
        return positiveNumbers.sumOf { it.value }
    }

    companion object {
        private const val DEFAULT_DATA = "0"
    }
}
