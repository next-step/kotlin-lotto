package calculator.domain

class StringAddCalculator(private val inputExpressionParser: InputExpressionParser) {
    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) {
            return 0
        }

        return inputExpressionParser.parse(input).getSum()
    }
}
