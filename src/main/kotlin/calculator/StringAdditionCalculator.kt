package calculator

import calculator.utils.Calculation
import calculator.utils.Conversion
import calculator.utils.Separator
import calculator.utils.Validation

class StringAdditionCalculator {

    fun main(text: String?): Int {
        if (text.isNullOrBlank()) return 0
        val separator = Separator.findSeparatorInString(text)
        val stringToAdd = Separator.getStringToAdd(text)
        val strings = Separator.divideBySeparator(separator, stringToAdd)

        Validation.isNumericAndNegativeNumber(strings)

        val ints = Conversion.stringArrayToIntArray(strings)

        return Calculation.intArraySum(ints)
    }
}
