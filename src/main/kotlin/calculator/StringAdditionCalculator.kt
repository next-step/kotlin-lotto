package calculator

class StringAdditionCalculator {
    fun calculate(expression: String?): Int {
        if (expression.isNullOrBlank()) {
            return 0
        }

        if (expression.contains(CUSTOM_DELIMITER_REGEX)) {
            val matchResult = CUSTOM_DELIMITER_REGEX.find(expression)!!
            val (_, customDelimiter, numberAdditionExpression) = matchResult.groupValues
            return sumNumberAdditionExpression(numberAdditionExpression, customDelimiter)
        }

        return sumNumberAdditionExpression(expression)
    }

    private fun sumNumberAdditionExpression(numberAdditionExpression: String, customDelimiter: String? = null): Int {
        return splitExpressionByDelimiters(numberAdditionExpression, customDelimiter)
            .sumBy { it.toInt() }
    }

    private fun splitExpressionByDelimiters(numberAdditionExpression: String, customDelimiter: String?): List<String> {
        return numberAdditionExpression.split(
            *listOfNotNull(customDelimiter, COMMA_DELIMITER, COLON_DELIMITER).toTypedArray()
        )
    }

    companion object {
        private const val COMMA_DELIMITER = ","
        private const val COLON_DELIMITER = ":"
        private val CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)".toRegex()
    }
}
