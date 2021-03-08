package calculator.parser

class CustomExpressionParser : ExpressionParser {

    override fun support(expression: String): Boolean = PATTERN.containsMatchIn(expression)

    override fun parse(expression: String): List<String> {
        return PATTERN.find(expression)?.let {
            val customDelimiter = it.groupValues[1]
            it.groupValues[2].split(customDelimiter)
        } ?: listOf()
    }


    companion object {
        private val PATTERN = Regex("//(.)\\\\n(.*)")
    }
}