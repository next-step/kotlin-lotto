package stringcalculator

class StringCalculator(
    private val parser: StringCalculatorParser
) {

    fun sum(numbersAsString: String): Int {
        val numbers = parser.parse(numbersAsString)
        return numbers.sum()
    }
}
