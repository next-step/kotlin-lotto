package stringaddcalculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        validateNoNegativeNumbers(text)

        if (containsOnlyOneNumber(text)) {
            return text.toInt()
        }

        val numbers = convertToNumbers(text)
        return numbers.sum()
    }

    private fun validateNoNegativeNumbers(text: String) {
        if (text.contains(NEGATIVE_NUMBER_REGEX)) {
            throw IllegalArgumentException("음수는 포함될 수 없습니다. 현재 입력 = $text")
        }
    }

    private fun containsOnlyOneNumber(text: String): Boolean {
        return text.matches(DIGITS_ONLY_REGEX)
    }

    private fun convertToNumbers(text: String): List<Int> {
        val strNumbers: List<String> = extractNumbers(text)
        return strNumbers.map { strNumber ->
            strNumber.toInt()
        }
    }

    private fun extractNumbers(text: String): List<String> {
        return if (text.contains(CUSTOM_DELIMITER_REGEX)) {
            val matchResult = CUSTOM_DELIMITER_REGEX.find(text) ?: return emptyList()

            val delimiter = matchResult.groupValues[1]
            matchResult.groupValues[2].split(delimiter)
        } else {
            text.split(DEFAULT_DELIMITER_REGEX)
        }
    }

    companion object {
        private val NEGATIVE_NUMBER_REGEX = Regex("-[0-9]+\$")
        private val DIGITS_ONLY_REGEX = Regex("^[0-9]+\$")
        private val DEFAULT_DELIMITER_REGEX = Regex("[,:]")
        private val CUSTOM_DELIMITER_REGEX = Regex("//(.)\\n(.*)")
    }
}