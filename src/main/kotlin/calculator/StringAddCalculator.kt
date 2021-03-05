package calculator

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        val customDelimiterPatterns = findCustomDelimiters(text).map { "[$it]" }

        val removedCustomPatternText = text.replace(CUSTOM_DELIMITER_PATTERN.toRegex(), EMPTY)

        val regex = DEFAULT_DELIMITER_PATTERNS.plus(customDelimiterPatterns)
            .joinToString(separator = "|")
            .toRegex()

        val numbers = removedCustomPatternText.split(regex).map { it.toInt() }

        checkNegative(numbers)
        return numbers.sum()
    }

    private fun findCustomDelimiters(text: String): List<String> {
        return Regex(CUSTOM_DELIMITER_PATTERN).findAll(text)
            .map {
                it.let { it.groupValues[1] }
            }.toList()
    }

    private fun checkNegative(numbers: List<Int>) {
        if (numbers.any { it < 0 }) {
            throw RuntimeException()
        }
    }

    companion object {
        private val DEFAULT_DELIMITER_PATTERNS = listOf("[,]", "[:]")
        private const val CUSTOM_DELIMITER_PATTERN = "//(.)\n"
        private const val EMPTY = "";
    }
}
