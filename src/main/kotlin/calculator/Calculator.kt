package calculator

object Calculator {

    private const val DEFAULT_RESULT = 0
    private const val EXPRESSION_INDEX = 2
    private const val DELIMITER_INDEX = 1
    private val DEFAULT_DELIMITERS = listOf(",", ":")
    private val WITH_DELIMITER_REGEX = Regex("//(.)\n(.*)")

    fun add(expression: String?): Int {
        if (expression.isNullOrEmpty()) {
            return DEFAULT_RESULT
        }
        val (parsedExpression, delimiters) = parse(expression)
        return parsedExpression.split(*delimiters.toTypedArray())
            .sumOf { PositiveInt(it).value }
    }

    private fun parse(expression: String): ParseResult {
        val result = WITH_DELIMITER_REGEX.find(expression)
            ?: return ParseResult(expression, DEFAULT_DELIMITERS)
        return ParseResult(
            result.groupValues[EXPRESSION_INDEX],
            DEFAULT_DELIMITERS + result.groupValues[DELIMITER_INDEX],
        )
    }

    private data class ParseResult(val expression: String, val delimiters: List<String>)
}
