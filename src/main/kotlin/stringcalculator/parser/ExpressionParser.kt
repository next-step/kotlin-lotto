package stringcalculator.parser

import stringcalculator.Operand

interface ExpressionParser {
    fun getOperands(input: String): List<Operand>
}
