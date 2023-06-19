package calculator

class StringAddCalculator {
    fun calculate(expression: String?): Long {
        if (expression.isNullOrEmpty()) {
            return DEFAULT_VALUE
        }

        return StringParser().parsingNumbers(expression).sum()
    }

    companion object {
        private const val DEFAULT_VALUE = 0L
    }
}
