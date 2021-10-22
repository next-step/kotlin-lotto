package calculator

import calculator.utils.StringUtils

class StringAddCalculator {

    fun add(text: String?): Int {
        require(!text.isNullOrBlank()) { return 0 }
        val splitText = StringUtils.splitTextByDelimiter(text)
        return sum(StringUtils.toNumbers(splitText))
    }

    private fun sum(numbers: List<Int>): Int {
        return numbers.fold(0) { total, num -> total + num }
    }
}
