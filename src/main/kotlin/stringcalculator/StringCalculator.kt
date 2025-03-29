package stringcalculator

class StringCalculator {
    fun add(expression: String): Int {
        val (numbers, delimiters) = parseExpression(expression)
        return numbers.split(*delimiters)
            .map { it.trim() }
            .sumOf { it.toInt() }
    }

    private fun List<String>.toInt(): List<Int> {
        return map { it.toInt() }
    }

    private fun parseExpression(expression: String): Pair<String, Array<String>> {
        val regex = Regex(pattern = CUSTOM_DELIMITER_REGEX)
        val matchResult = regex.matchEntire(expression)

        return if (matchResult != null) {
            val (customDelimiter, content) = matchResult.destructured
            content to arrayOf(customDelimiter) + DEFAULT_DELIMITERS
        } else {
            expression to DEFAULT_DELIMITERS
        }
    }

    companion object {
        private const val CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)"
        private const val COMMA = ","
        private const val COLON = ":"
        private val DEFAULT_DELIMITERS = arrayOf(COLON, COMMA)
    }
}
