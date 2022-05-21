package stringcalculator.service

import stringcalculator.domain.Calculator
import stringcalculator.domain.StringExpressionParser

class CustomExpressionCalculator(expression: String) {
    private val stringExpressionParser: StringExpressionParser = StringExpressionParser(expression)

    fun getTotal(): Int {
        return Calculator.getTotalSum(stringExpressionParser.getParsedNumber())
    }
}
