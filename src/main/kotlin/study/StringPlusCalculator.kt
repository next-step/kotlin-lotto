package study

object StringPlusCalculator {
    private const val NULL_OR_BLANK_INPUT_RETURN_VALUE = 0

    fun calculate(expression: String?): Int {
        if (expression.isNullOrBlank()) return NULL_OR_BLANK_INPUT_RETURN_VALUE
        val numbers = StringPlusCalculatorParser.parse(expression)
        return numbers.sum()
    }
}
