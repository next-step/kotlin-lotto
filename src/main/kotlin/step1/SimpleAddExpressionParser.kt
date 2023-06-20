package step1

import java.lang.RuntimeException

class SimpleAddExpressionParser : ExpressionParser {
    private val baseDelimiterRegex: Regex = ",|:".toRegex()
    private val customDelimiterRegex = Regex("//(.)\n(.*)")

    override fun parse(expression: String?): Expression {
        if (!isValidExpressionString(expression))
            return Expression(operands = listOf(0), operators = listOf())

        val tokenizedExpression: List<String> = tokenizeExpression(expression!!)

        return createExpression(tokenizedExpression)
    }

    private fun isValidExpressionString(expression: String?): Boolean {
        if (expression.isNullOrBlank() || expression.isNullOrBlank()) {
            return false
        }
        return true
    }

    private fun tokenizeExpression(expression: String): List<String> {
        val matchResult: MatchResult? = customDelimiterRegex.find(expression)
        if (matchResult != null) {
            val customDelimiter: String = matchResult.groupValues[1]
            return matchResult.groupValues[2].trim().split(customDelimiter)
        }

        return expression.trim().split(baseDelimiterRegex)
    }

    private fun createExpression(tokenizedExpression: List<String>): Expression {
        val operands = tokenizedExpression.map { token ->
            val number: Int = token.toIntOrNull() ?: throw RuntimeException("숫자가 아닌 값이 포함되어 있습니다 [$token]")
            require(number >= 0) { "음수가 포함되어 있습니다 [$token]" }
            number
        }

        val operators = List(tokenizedExpression.size - 1) { _ -> Operator.ADD }

        return Expression(operands, operators)
    }
}
