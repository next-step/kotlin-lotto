package calculator.domain

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty() || text.isBlank()) {
            return MINIMUM_NUMBER
        }

        val (delimiter, expression) = getDelimiterAndExpression(text)

        val numbers = expression.split(delimiter.toRegex()).map {it.toInt()}
        numbers.forEach { require(it >= MINIMUM_NUMBER) }

        return numbers.sumOf { it }
    }

    private fun getDelimiterAndExpression(text: String): Pair<String, String> {
        val matchResult = Regex("//(.)\n(.*)").find(text) ?: return Pair(DEFAULT_DELIMITER, text)

        return Pair(matchResult.groupValues[1], matchResult.groupValues[2])
    }

    companion object {
        const val MINIMUM_NUMBER = 0
        const val DEFAULT_DELIMITER = ",|:"
    }
}

