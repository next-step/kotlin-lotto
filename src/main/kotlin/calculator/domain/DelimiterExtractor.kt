package calculator.domain

interface DelimiterExtractor {
    fun extract(expression: String): List<Long>
    fun isValidExpression(expression: String): Boolean
}
