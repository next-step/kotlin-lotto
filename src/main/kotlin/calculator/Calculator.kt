package calculator

object Calculator {

    private const val DEFAULT_RESULT = 0
    private val expressionRegex = Regex("//(.)\n(.*)")

    fun add(expression: String?): Int {
        if (expression.isNullOrEmpty()) {
            return DEFAULT_RESULT
        }
        val (parsedExpression, delimiters) = parseDelimiter(expression)
        return parsedExpression.split(*delimiters.toTypedArray())
            .sumOf { it.toPositiveInt() }
    }

    private fun parseDelimiter(expression: String): ParseResult {
        val result = expressionRegex.find(expression)
        return result?.let { ParseResult(it.groupValues[2], it.groupValues[1]) }
            ?: ParseResult(expression, listOf(",", ":"))
    }

    private data class ParseResult(val expression: String, val delimiters: List<String>) {
        constructor(expression: String, delimiter: String) : this(expression, listOf(delimiter))
    }

    private fun String.toPositiveInt(): Int {
        return toIntOrNull()?.takeIf { it >= 0 } ?: throw RuntimeException("$this 은/는 양의 정수가 아닙니다.")
    }
}
