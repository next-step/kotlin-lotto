package calculator

class StringAddCalculator(expression: String?) {

    private var calculateValues = mutableListOf<String>()

    init {
        addCalculateValues(expression)
    }

    fun add(): Int {
        var sum = 0
        calculateValues
            .map { PositiveNumber(it) }
            .forEach { sum = it.add(sum) }
        return sum
    }

    private fun addCalculateValues(expression: String?) {
        if (expression.isNullOrBlank()) {
            calculateValues.add("0")
            return
        }

        var currentExpression = expression
        var delimiter = DEFAULT_DELIMITER

        val matches = DELIMITER_REGEX.find(currentExpression)
        if (matches != null) {
            delimiter = matches.groupValues[DELIMITER_MATCHER_GROUP]
            currentExpression = matches.groupValues[INPUT_NUMBER_MATCHER_GROUP]
        }

        calculateValues.addAll(splitDelimiter(currentExpression, delimiter))
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
