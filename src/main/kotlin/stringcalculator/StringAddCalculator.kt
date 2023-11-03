package stringcalculator

object StringAddCalculator {
    private const val ZERO = 0
    private const val CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)"
    private const val DEFAULT_DELIMITERS = ",|:"

    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) return ZERO

        val (delimiter, numbersText) = findCustomDelimiterAndNumbers(text)
        val numbers = splitByDelimiter(numbersText, delimiter)
        return sum(numbers)
    }

    private fun findCustomDelimiterAndNumbers(text: String?): Pair<String, String> {
        val result = Regex(CUSTOM_DELIMITER_REGEX).find(text.orEmpty())
        return when {
            result != null -> result.groupValues[1] to result.groupValues[2]
            else -> DEFAULT_DELIMITERS to text.orEmpty()
        }
    }

    private fun splitByDelimiter(text: String, delimiter: String): List<String> {
        return text.split(delimiter.toRegex())
    }

    private fun sum(numbers: List<String>): Int {
        return numbers.sumOf {
            val number = it.toInt()
            require(number >= 0) { "Negative number not allowed: $number" }
            number
        }
    }
}
