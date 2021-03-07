package calculator

object StringCalculator {

    private const val BASE_DELIMETER_COMMA = ","
    private const val BASE_DELIMETER_COLON = ":"
    private const val CUSTOM_DELIMETER_INDEX = 2
    private const val MIN_LENGTH_WITH_CUSTOM_EXPRESSION = 6
    private val CUSTOM_DELIMETER_EXPRESSION_RANGE = 0..5

    fun calculate(input: String): Int {

        var adjustedInput = input
        if (hasCustomDelimeter(input)) {
            adjustedInput = adjustCustomExpression(input)
        }
        val nums = splitNum(adjustedInput)
        return nums.sum()
    }

    private fun hasCustomDelimeter(input: String): Boolean {

        if (input.length < MIN_LENGTH_WITH_CUSTOM_EXPRESSION) return false

        val startString = input.substring(CUSTOM_DELIMETER_EXPRESSION_RANGE)
        Regex("""//(.)\n""").find(startString) ?: return false

        return true
    }

    private fun adjustCustomExpression(input: String): String {
        val customDelimeter = input.substring(CUSTOM_DELIMETER_INDEX, CUSTOM_DELIMETER_INDEX + 1)
        val expressionDeletedInput = Regex("""//(.)\n""").replace(input, "")
        return expressionDeletedInput.replace(customDelimeter, BASE_DELIMETER_COMMA)
    }

    private fun splitNum(input: String): List<Int> {
        return input.split(BASE_DELIMETER_COMMA, BASE_DELIMETER_COLON).map { it.toInt() }
    }
}
