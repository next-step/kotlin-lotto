package stringcalculator

import stringcalculator.parser.ExpressionParser

class StringCalculator(private val parser: ExpressionParser) {
    fun add(input: String): Operand {
        val operands = parser.getOperands(input)
        return addAll(operands)
    }

    private fun addAll(operands: List<Operand>): Operand {
        return operands.reduce { acc, operand -> acc + operand }
    }
}
