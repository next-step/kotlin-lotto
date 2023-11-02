package stringcalculator

class StringCalculator(
    private val stringParser: StringParser
) {

    fun sum(numbersAsString: String): Int {
        val numbers = stringParser.parse(numbersAsString)
        return numbers.sum()
    }
}
