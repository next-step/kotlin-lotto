package stringcalculator

class StringCalculator {
    fun add(expression: String): Int {
        val parsedExpression = parseExpression(expression)
        return parsedExpression.numbers.split(*parsedExpression.delimiters).sum()
    }

    private fun List<String>.sum(): Int {
        val numbers = map { it.toIntOrNull() ?: throw IllegalArgumentException() }
        if (numbers.any { it < MINUMUM_VALUE }) throw IllegalArgumentException()
        return numbers.sum()
    }

    private fun parseExpression(expression: String): ParsedExpression {
        val regex = Regex(pattern = CUSTOM_DELIMITER_REGEX)
        val matchResult = regex.matchEntire(expression)

        return if (matchResult != null) {
            val (customDelimiter, content) = matchResult.destructured
            ParsedExpression(content, arrayOf(customDelimiter) + DEFAULT_DELIMITERS)
        } else {
            ParsedExpression(expression, DEFAULT_DELIMITERS)
        }
    }

    companion object {
        private const val CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)"
        private const val COMMA = ","
        private const val COLON = ":"
        private val DEFAULT_DELIMITERS = arrayOf(COLON, COMMA)
        private val MINUMUM_VALUE = 0
    }
}
