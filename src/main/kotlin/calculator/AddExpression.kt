package calculator

class AddExpression(text: String) {
    private val numbers: List<Int>

    init {
        val delimiter = extractCustomDelimiter(text) ?: DEFAULT_DELIMITER
        val expression = extractExpression(text) ?: text
        numbers = expression.split(delimiter.toRegex()).map { it.toInt() }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    fun extractCustomDelimiter(text: String): String? {
        return EXPRESSION_REGEX.find(text)?.groupValues?.get(DELIMITER_INDEX)
    }

    fun extractExpression(text: String): String? {
        return EXPRESSION_REGEX.find(text)?.groupValues?.get(EXPRESSION_INDEX)
    }

    companion object {
        private val EXPRESSION_REGEX = Regex("//(.)\n(.*)")
        private const val DELIMITER_INDEX = 1
        private const val EXPRESSION_INDEX = 2
        private const val DEFAULT_DELIMITER = ",|:"
    }
}
