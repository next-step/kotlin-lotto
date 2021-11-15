package addcalculator.service

import addcalculator.domain.Calculator
import addcalculator.domain.SplitStringDelimiter
import addcalculator.domain.StringValue

class StringCalculator(private val inputString: String) {

    fun calculator(): Int {
        return Calculator.sum(splitStrings())
    }

    private fun splitStrings(): List<StringValue> {
        return convertStringToStringValueObject(SplitStringDelimiter.splitValue(inputString))
    }

    private fun convertStringToStringValueObject(stringNumbers: List<String>): List<StringValue> {
        return stringNumbers.map { StringValue(it) }
    }
}
