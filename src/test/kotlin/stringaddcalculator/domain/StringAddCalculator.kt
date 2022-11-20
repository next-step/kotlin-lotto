package stringaddcalculator.domain

class StringAddCalculator {

    fun add(text: String?): Int {
        val positiveNumbers = PositiveNumbers(text)
        return positiveNumbers.sum()
    }
}
