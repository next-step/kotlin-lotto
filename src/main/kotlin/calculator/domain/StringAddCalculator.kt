package calculator.domain

class StringAddCalculator(private val inputExpressionParser: InputExpressionParser) {
    fun calculate(input: String?): Int {
        return inputExpressionParser.parse(input).getSum()
    }
}
