package calculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        var inputString = text
        var delimiter = DEFAULT_DELIMITER

        val matches = DELIMITER_REGEX.find(inputString)
        if (matches != null) {
            delimiter = matches.groupValues[DELIMITER_MATCHER_GROUP]
            inputString = matches.groupValues[INPUT_NUMBER_MATCHER_GROUP]
        }

        var sum = 0

        splitDelimiter(inputString, delimiter)
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
