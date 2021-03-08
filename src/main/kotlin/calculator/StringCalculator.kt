package calculator

import calculator.parser.ExpressionParser
import calculator.parser.TokenExpressionParser

class StringCalculator(private val parserGroup: List<ExpressionParser> = listOf()) {

    fun add(expression: String?): PositiveNumber {
        if (expression.isNullOrBlank()) {
            return PositiveNumber.ZERO
        }

        val parser = this.parserGroup.find { it.support(expression) } ?: DEFAULT_TOKEN_PARSER
        return parser.parse(expression)
            .map { PositiveNumber.ofString(it) }
            .reduce { left, right -> left.sum(right) }
    }

    companion object{
        private val DEFAULT_TOKEN_PARSER = TokenExpressionParser(":", ",")
    }

}