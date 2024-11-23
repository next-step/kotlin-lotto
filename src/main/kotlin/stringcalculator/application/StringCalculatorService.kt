package stringcalculator.application

import stringcalculator.core.Calculator
import stringcalculator.core.FormulaParser

object StringCalculatorService {
    fun calculate(formula: String?): Int {
        val numbers = FormulaParser.parse(formula)
        return Calculator.sum(numbers)
    }
}
