package calculator

object Parser {
    private val parseRegex by lazy { Regex("(?://(.*)\n)?(.*)") }
    private const val DEFAULT_DELIMITERS = ",|;"

    fun parse(input: String?): List<String> {
        return if (input.isNullOrEmpty()) listOf()
        else {
            val (delimiters, expression) = parseDelimiterAndExpression(input)
            expression.split(delimiters.toRegex())
        }
    }

    private fun parseDelimiterAndExpression(input: String): Pair<String, String> {
        return parseRegex.find(input)?.let {
            val (delimiter, expression) = it.destructured
            if (delimiter.isEmpty()) DEFAULT_DELIMITERS to expression
            else delimiter to expression
        } ?: (DEFAULT_DELIMITERS to input)
    }
}
