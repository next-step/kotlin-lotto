package calculator

object StringCalculator {

    private const val BASE_DELIMETER = ","
    private const val BASE_DELIMETER_COMMA = ","
    private const val BASE_DELIMETER_COLON = ":"
    private const val DEFAULT_VALUE_OF_NULL_OR_EMPTY = 0
    private const val CUSTOM_DELIMETER_INDEX = 2
    private const val CUSTOM_DELIMETER_EXPRESSION_LENGTH = 6
    private const val CUSTOM_DELIMETER_EXPRESSION_REGEX = """//(.)\n"""
    private const val CUSTOM_EXPRESSION_ = 6
    private const val WRONG_INPUT_EXCEPTION_MESSGAE = "잘못된 입력값이 있습니다."
    private val CUSTOM_DELIMETER_EXPRESSION_RANGE = 0..5

    fun calculate(input: String?): Int {

        if (input.isNullOrBlank()) {
            return DEFAULT_VALUE_OF_NULL_OR_EMPTY
        }

        var adjustedInput = input
        if (hasCustomDelimeter(input)) {
            adjustedInput = adjustCustomExpression(input)
        }

        val nums = splitNum(adjustedInput)
        return nums.sum()
    }

    private fun hasCustomDelimeter(input: String): Boolean {

        if (input.length < CUSTOM_DELIMETER_EXPRESSION_LENGTH) return false

        val startString = input.substring(CUSTOM_DELIMETER_EXPRESSION_RANGE)
        Regex(CUSTOM_DELIMETER_EXPRESSION_REGEX).find(startString) ?: return false

        return true
    }

    private fun adjustCustomExpression(input: String): String {
        val expressionDeletedInput = removeCustomDelimeterExpression(input)
        val customDelimeter = getCustomDelimeter(input)
        return replaceCustomDelimeterToBaseDelimeter(expressionDeletedInput, customDelimeter)
    }

    private fun getCustomDelimeter(input: String): String =
        input.substring(CUSTOM_DELIMETER_INDEX, CUSTOM_DELIMETER_INDEX + 1)

    private fun removeCustomDelimeterExpression(input: String): String =
        Regex(CUSTOM_DELIMETER_EXPRESSION_REGEX).replace(input, "")

    private fun replaceCustomDelimeterToBaseDelimeter(input: String, customDelimeter: String): String =
        input.replace(customDelimeter, BASE_DELIMETER)

    private fun splitNum(input: String): List<Int> {
        return input.split(BASE_DELIMETER_COMMA, BASE_DELIMETER_COLON).map {
            validateNum(it)
            it.toInt()
        }
    }

    private fun validateNum(numberOfString: String) {

        val num = numberOfString.toIntOrNull() ?: throw RuntimeException(WRONG_INPUT_EXCEPTION_MESSGAE)

        if (num < 0) {
            throw RuntimeException(WRONG_INPUT_EXCEPTION_MESSGAE)
        }
    }
}
