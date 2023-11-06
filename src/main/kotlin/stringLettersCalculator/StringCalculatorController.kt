package stringLettersCalculator

class StringCalculatorController(
    private val stringCalculator: StringCalculator = StringCalculator()
) {

    fun answerToSum(letters: String): Int {
        return stringCalculator.calculate(letters)
    }
}