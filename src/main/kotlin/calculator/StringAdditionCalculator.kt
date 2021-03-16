package calculator

class StringAdditionCalculator {
    fun calculate(expression: String?): Int {
        if (expression.isNullOrBlank()) {
            return 0
        }

        if (expression.contains(CUSTOM_DELIMITER_REGEX)) {
            val matchResult = CUSTOM_DELIMITER_REGEX.find(expression)!!
            val customDelimiter = matchResult.groupValues[1]
            val numberAdditionExpression = matchResult.groupValues[2]
            return numberAdditionExpression.split(customDelimiter, COMMA_DELIMITER, COLON_DELIMITER)
                .sumBy { it.toInt() }
        }

        return expression.split(COMMA_DELIMITER, COLON_DELIMITER)
            .sumBy { it.toInt() }
    }

    companion object {
        private const val COMMA_DELIMITER = ","
        private const val COLON_DELIMITER = ":"
        private val CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)".toRegex()
    }
}
