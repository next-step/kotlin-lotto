package calculator.domain

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty() || text.isBlank()) {
            return MINIMUM_NUMBER
        }

        val (delimiter, expression) = getDelimiterAndExpression(text)

        val numbers = expression.split(delimiter).map { it.toInt() }
        numbers.forEach { require(it >= MINIMUM_NUMBER) }

        return numbers.sumOf { it }
    }

    private fun getDelimiterAndExpression(text: String): Pair<Regex, String> {
        val matchResult = CUSTOM_DELIMITER_CHECK_REGEX.find(text) ?: return Pair(DEFAULT_DELIMITER_REGEX, text)

        return Pair(matchResult.groupValues[1].toRegex(), matchResult.groupValues[2])
    }

    companion object {
        const val MINIMUM_NUMBER = 0
        val DEFAULT_DELIMITER_REGEX = Regex(",|:")
        val CUSTOM_DELIMITER_CHECK_REGEX = Regex("//(.)\n(.*)")
    }
}

