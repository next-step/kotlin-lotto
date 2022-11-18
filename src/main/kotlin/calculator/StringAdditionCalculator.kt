package calculator

import calculator.utils.Calculation
import calculator.utils.Separator

class StringAdditionCalculator {

    fun main(text: String?): Int {
        if (text.isNullOrBlank()) return 0
        val separator = Separator.findSeparatorInString(text)
        val nextText = Separator.getNextValue(text)
        val strings = Separator.divideBySeparator(separator, nextText)
        return Calculation.stringArraySum(strings)
    }
}
