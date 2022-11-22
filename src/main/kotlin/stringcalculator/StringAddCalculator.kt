package stringcalculator

import stringcalculator.model.PositiveNumber
import stringcalculator.model.PositiveNumbers
import stringcalculator.service.StringParser.convertToList

object StringAddCalculator {
    fun calculate(input: String): PositiveNumber {
        return PositiveNumbers.of(convertToList(input)).reduceAdd()
    }
}
