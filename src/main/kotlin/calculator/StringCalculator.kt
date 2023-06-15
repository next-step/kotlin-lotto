package calculator

class StringCalculator {

    fun calculate(input: String?): Int = when {
        input.isNullOrEmpty() -> 0
        else -> ExpressionParser.parse(input)
    }
}
