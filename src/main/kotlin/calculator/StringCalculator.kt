package calculator

object StringCalculator {

    private const val BASE_DELIMETER_COMMA = ","
    private const val BASE_DELIMETER_COLON = ":"

    fun calculate(input: String): Int {

        val delimeter = getDelimeterIfExist(input)
        val adjustedInput = removeCustomDelimeterExpressionIfExist(input)
        val nums = splitNum(adjustedInput, delimeter)
        return nums.sum()
    }

    private fun removeCustomDelimeterExpressionIfExist(input: String): String {
        return Regex("""//(.)\n""").replace(input, "")
    }

    private fun getDelimeterIfExist(input: String): String? {

        if (input.length < 6) return null

        val startString = input.substring(0, 6)
        Regex("""//(.)\n""").find(startString) ?: return null
        return input.substring(2, 3)
    }

    private fun splitNum(input: String, customDelimeter: String?): List<Int> {
        if (customDelimeter == null) {
            return input.split(BASE_DELIMETER_COMMA, BASE_DELIMETER_COLON).map { it.toInt() }
        }
        return input.split(BASE_DELIMETER_COMMA, BASE_DELIMETER_COLON, customDelimeter).map { it.toInt() }
    }
}
