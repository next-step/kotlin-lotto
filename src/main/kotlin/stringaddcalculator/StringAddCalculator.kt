package stringaddcalculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        validateContainsNegativeNumber(text)

        if (containsOnlyOneNumber(text)) {
            return text.toInt()
        }

        val numbers = getNumbers(text)
        return sumAll(numbers)
    }

    private fun validateContainsNegativeNumber(text: String) {
        if (text.contains(NEGATIVE_NUMBER_REGEX)) {
            throw IllegalArgumentException("음수는 포함될 수 없습니다. 현재 입력 = $text")
        }
    }

    private fun containsOnlyOneNumber(text: String): Boolean {
        return text.matches(DIGITS_ONLY_REGEX)
    }

    private fun getNumbers(text: String): List<Int> {
        if (text.contains(CUSTOM_DELIMITER_REGEX)) {
            val matchResult = CUSTOM_DELIMITER_REGEX.find(text) ?: return emptyList()

            val delimiter = matchResult.groupValues[1]
            val strNumbers = matchResult.groupValues[2].split(delimiter)

            return strNumbers.map { strNumber ->
                strNumber.toInt()
            }
        }

        return text.split(DEFAULT_DELIMITER_REGEX)
            .map { strNumber -> strNumber.toInt() }
    }

    private fun sumAll(numbers: List<Int>): Int {
        return numbers.sum()
    }

    companion object {
        private val NEGATIVE_NUMBER_REGEX = Regex("-[0-9]+\$")
        private val DIGITS_ONLY_REGEX = Regex("^[0-9]+\$")
        private val DEFAULT_DELIMITER_REGEX = Regex("[,:]")
        private val CUSTOM_DELIMITER_REGEX = Regex("//(.)\\n(.*)")
    }
}