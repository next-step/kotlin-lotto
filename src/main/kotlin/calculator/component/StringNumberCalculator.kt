package calculator.component

class StringNumberCalculator(
    private val stringNumberParser: StringNumberParser
) {
    fun calculate(expression: String?): Int {
        return stringNumberParser
            .getNumbers(expression)
            .sum()
    }
}
