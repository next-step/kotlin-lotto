package stringcalculator.application

import stringcalculator.core.Calculator
import stringcalculator.core.StringParser

class StringCalculatorService {
    fun calculate(string: String?): Int {
        val numberList = StringParser.parse(string)
        return Calculator.sum(numberList)
    }
}
