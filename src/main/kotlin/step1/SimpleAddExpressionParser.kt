package step1

import java.lang.RuntimeException

class SimpleAddExpressionParser : ExpressionParser {

    override fun parse(expression: String?): Expression {
        if (expression.isNullOrBlank() || expression.isNullOrBlank()) {
            return Expression(operands = listOf(0), operators = listOf())
        }

        val tokenizedExpression = tokenizeExpression(expression)

        return createExpression(tokenizedExpression)
    }

    private fun tokenizeExpression(expression: String): List<String> {
        val customDelimiter = Regex("//(.)\n(.*)").find(expression)
        customDelimiter?.let {
            val customDelimiter = it.groupValues[1]
            return it.groupValues[2].trim().split(customDelimiter)
        }

        val baseDelimiter = ",|:".toRegex()
        return expression.trim().split(baseDelimiter)
    }

    private fun createExpression(tokenizedExpression: List<String>): Expression {
        val operands = tokenizedExpression.map { token ->
            val number = token.toIntOrNull()
            number ?: throw RuntimeException("숫자가 아닌 값이 포함되어 있습니다 [$token]")
            require(number >= 0) { "음수가 포함되어 있습니다 [$token]" }
            number
        }

        val operators = List(tokenizedExpression.size - 1) { _ -> Operator.ADD }

        return Expression(operands, operators)
    }
}
