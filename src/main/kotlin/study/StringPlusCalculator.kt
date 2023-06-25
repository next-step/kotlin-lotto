package study

object StringPlusCalculator {
    private const val NULL_OR_BLANK_INPUT_RETURN_VALUE = 0

    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) return NULL_OR_BLANK_INPUT_RETURN_VALUE
        val numbers = StringPlusCalculatorParser.parse(input)
        return numbers.sum()
    }
}
