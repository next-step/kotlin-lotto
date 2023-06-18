package calculator

class StringCalculator {

    fun calculate(input: String?): Int = when {
        input.isNullOrEmpty() -> 0
        else -> {
            val strategy = if (ExpressionParser.hasCustomDelimiter(input)) {
                CustomDelimiterStrategy()
            } else {
                DefaultDelimiterStrategy()
            }

            ExpressionParser.parse(input, strategy).sumOf { it }
        }
    }
}
