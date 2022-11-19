package stringCalculator

class StringAddCalculator {
    fun sum(inputValue: String?): Int {
        if (inputValue.isNullOrBlank()) {
            return DEFAULT_VALUE
        }

        val matchedCustomDelimiter = CUSTOM_DELIMITER_REGEX.find(inputValue)

        val stringList = matchedCustomDelimiter?.let { split(it.groupValues[1], it.groupValues[2]) } ?: split(inputValue)

        validateNumber(stringList)

        return sum(stringList)
    }

    private fun split(string: String): List<String> {
        return string.split(DEFAULT_DELIMITER_REGEX)
    }

    private fun split(delimiter: String, string: String): List<String> {
        if (delimiter.isEmpty()) {
            return split(string)
        }
        return string.split(delimiter)
    }

    private fun sum(stringList: List<String>) = stringList.sumOf { it.toInt() }

    companion object {
        private const val DEFAULT_VALUE = 0

        private val DEFAULT_DELIMITER_REGEX = Regex("[,:]")

        private val POSITIVE_INTEGER_REGEX = Regex("\\+?[0-9]+")

        val CUSTOM_DELIMITER_REGEX = Regex("//(.*)\n(.*)")

        private fun validateNumber(strings: List<String>) {
            strings.forEach {
                require(it.matches(POSITIVE_INTEGER_REGEX)) { "숫자가 아닌 값 혹은 음수를 입력하였습니다. (입력값:$it)" }
            }
        }
    }
}