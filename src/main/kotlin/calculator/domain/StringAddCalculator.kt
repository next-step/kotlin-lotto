package calculator.domain

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty() || text.isBlank()) {
            return 0;
        }

        val result = getDelimiterAndExpression(text)
        val delimiter = result.first
        val expression = result.second

        val stringNumbers = expression.split(delimiter.toRegex())
        stringNumbers.forEach { require(it.toInt() >= MINIMUM_NUMBER) }

        return stringNumbers.sumOf { it.toInt() }
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

