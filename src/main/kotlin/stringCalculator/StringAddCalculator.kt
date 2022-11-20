package stringCalculator

class StringAddCalculator {
    fun sum(inputValue: String?): Int {
        if (inputValue.isNullOrBlank()) {
            return DEFAULT_VALUE
        }

        val matchedCustomDelimiter = CUSTOM_DELIMITER_REGEX.find(inputValue)

        val numberStrings = extractNumberStrings(inputValue, matchedCustomDelimiter)

        validateNumber(numberStrings)

        return sum(numberStrings)
    }

    private fun extractNumberStrings(inputValue: String, matchedCustomDelimiter: MatchResult?): List<String> {
        if (matchedCustomDelimiter == null) {
            return split(inputValue)
        }
        val string = matchedCustomDelimiter.groupValues[2]
        val delimiter = matchedCustomDelimiter.groupValues[1]
        return split(string, delimiter)
    }

    private fun split(string: String, delimiter: Regex = DEFAULT_DELIMITER_REGEX): List<String> = string.split(delimiter)

    private fun split(string: String, delimiter: String): List<String> {
        if (delimiter.isEmpty()) {
            return split(string)
        }
        return string.split(delimiter)
    }

    private fun sum(stringList: List<String>) = stringList.sumOf { it.toInt() }

    private fun validateNumber(numbers: List<String>) {
        numbers.forEach {
            require(it.matches(POSITIVE_INTEGER_REGEX)) { "숫자가 아닌 값 혹은 음수를 입력하였습니다. (입력값:$it)" }
        }
    }

    companion object {
        private const val DEFAULT_VALUE = 0

        private val DEFAULT_DELIMITER_REGEX = Regex("[,:]")

        private val POSITIVE_INTEGER_REGEX = Regex("\\+?[0-9]+")

        val CUSTOM_DELIMITER_REGEX = Regex("//(.*)\n(.*)")
    }
}