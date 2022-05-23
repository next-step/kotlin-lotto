package expressioncalculator

class Calculator(
    private val inputConverter: InputConverter,
    private val expressionParser: ExpressionParser
) {
    fun calculate(input: String?): Int {
        val expressionInput = inputConverter.convert(input ?: "")
        val numbers = expressionParser.parse(expressionInput)

        return numbers.sum()
    }
}
