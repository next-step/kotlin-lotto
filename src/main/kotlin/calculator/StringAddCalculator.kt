package calculator

class StringAddCalculator {
    fun add(expression: String?): Int {
        if (expression.isNullOrBlank()) {
            return 0
        }

        var currentExpression = expression
        var delimiter = DEFAULT_DELIMITER

        val matches = DELIMITER_REGEX.find(currentExpression)
        if (matches != null) {
            delimiter = matches.groupValues[DELIMITER_MATCHER_GROUP]
            currentExpression = matches.groupValues[INPUT_NUMBER_MATCHER_GROUP]
        }

        var sum = 0

        splitDelimiter(currentExpression, delimiter)
            .map { PositiveNumber(it) }
            .forEach { sum = it.add(sum) }

        return sum
    }

    private fun splitDelimiter(inputText: String, delimiter: String): Array<String> {
        return inputText.split(delimiter.toRegex()).toTypedArray()
    }

    companion object {
        private const val DEFAULT_DELIMITER = ",|:"
        private val DELIMITER_REGEX = Regex("//(.)\n(.*)")
        private const val DELIMITER_MATCHER_GROUP = 1
        private const val INPUT_NUMBER_MATCHER_GROUP = 2
    }
}
