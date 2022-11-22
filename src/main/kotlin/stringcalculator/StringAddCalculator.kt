package stringcalculator

import stringcalculator.model.PositiveNumber
import stringcalculator.service.StringParser

object StringAddCalculator {
    fun calculate(input: String): PositiveNumber {
        return StringParser.convertToList(input).reduceAdd()
    }
}
