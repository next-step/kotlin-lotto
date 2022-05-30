package calculator

import calculator.domain.Expression
import calculator.domain.Operand

class ExpressionParser {

    private fun findCustomDelimiter(input: String): MatchResult? {
        return CUSTOM_DELIMITER.toRegex().find(input)
    }

    private fun toExpression(tokens: List<String>): Expression {
        return Expression(tokens.map(::Operand))
    }

    fun parse(input: String): Expression {
        findCustomDelimiter(input)?.let {
            val customDelimiter = it.groupValues[1]
            val tokens = it.groupValues[2].split(customDelimiter)
            return toExpression(tokens)
        }

        val tokens = input.split(DELIMITERS.toRegex())
        return toExpression(tokens)
    }

    companion object {
        private const val DELIMITERS = "[,:]"
        private const val CUSTOM_DELIMITER = "//(.)\n(.*)"
    }
}
