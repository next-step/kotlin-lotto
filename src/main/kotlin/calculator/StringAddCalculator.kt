package calculator

class StringAddCalculator(private val stringParser: StringParser = StringParser()) {
    fun calculate(expression: String?): Long {
        if (expression.isNullOrEmpty()) {
            return DEFAULT_VALUE
        }

        return stringParser.parsingNumbers(expression)
            .sum()
    }

    companion object {
        private const val DEFAULT_VALUE = 0L
    }
}
