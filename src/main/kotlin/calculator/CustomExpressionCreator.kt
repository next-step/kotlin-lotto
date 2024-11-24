package calculator

import calculator.Patterns.CUSTOM_DELIMITER

object CustomExpressionCreator : ExpressionCreator {
    private const val SUBSTRING_TARGET_SEPARATOR = "\n"

    override fun create(expression: String): Expressions {
        val customDelimiter = extractCustomDelimiter(expression)
        val splicedExpression = expression.substringAfter(SUBSTRING_TARGET_SEPARATOR)

        return Expressions.created(splicedExpression, customDelimiter.toRegex())
    }

    private fun extractCustomDelimiter(expression: String): String {
        return CUSTOM_DELIMITER.regex.find(expression)?.let { matchResult ->
            matchResult.groupValues.getOrNull(1)
        } ?: throw IllegalArgumentException("커스텀 구분자가 존재하지 않습니다. input = $expression")
    }
}
