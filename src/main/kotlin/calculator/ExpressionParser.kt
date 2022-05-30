package calculator

import calculator.domain.Expression
import calculator.domain.Operand

class ExpressionParser {

    fun parse(input: String): Expression {
        return Expression(input.split(DELIMITERS.toRegex()).map(::Operand))
    }

    companion object {
        private const val DELIMITERS = "[,:]"
    }
}
