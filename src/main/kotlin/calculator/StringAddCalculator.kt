package calculator

import calculator.utils.StringUtils

class StringAddCalculator {

    fun add(text: String?): Int {
        require(!text.isNullOrBlank()) { return 0 }
        val splitText = StringUtils.splitTextByDelimiter(text, COMMA_AND_COLON)
        return sum(StringUtils.toNumbers(splitText))
    }

    private fun sum(numbers: List<Int>): Int {
        return numbers.fold(0) { total, num -> total + num }
    }

    companion object {
        private const val COMMA_AND_COLON = ",|:"
    }
}
