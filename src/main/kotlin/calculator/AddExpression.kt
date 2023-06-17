package calculator

class AddExpression(text: String) {
    val numbers: Numbers

    init {
        val delimiter = extractCustomDelimiter(text)
        val expression = extractExpression(text)
        numbers = Numbers(expression.split(delimiter.toRegex()).map { it.toInt() })
    }

    fun sum(): Int {
        return numbers.sum()
    }

    private fun extractCustomDelimiter(text: String): String {
        return EXPRESSION_REGEX.find(text)?.groupValues?.get(DELIMITER_INDEX) ?: DEFAULT_DELIMITER
    }

    private fun extractExpression(text: String): String {
        return EXPRESSION_REGEX.find(text)?.groupValues?.get(EXPRESSION_INDEX) ?: text
    }

    companion object {
        private val EXPRESSION_REGEX = Regex("//(.)\n(.*)")
        private const val DELIMITER_INDEX = 1
        private const val EXPRESSION_INDEX = 2
        private const val DEFAULT_DELIMITER = ",|:"
    }
}
