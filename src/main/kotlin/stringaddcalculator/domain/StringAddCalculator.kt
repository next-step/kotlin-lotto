package stringaddcalculator.domain

import stringaddcalculator.util.ExpressionParser

class StringAddCalculator {
    fun calculate(calculationInput: String?): Int {
        if (calculationInput.isNullOrBlank()) return 0
        val stringNumbers = ExpressionParser().parse(calculationInput)
        val operands = OperandCollection.of(stringNumbers)
        return operands.plusAllNumbers().number
    }
}
