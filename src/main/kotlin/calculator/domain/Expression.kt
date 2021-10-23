package calculator.domain

class Expression(
    private val value: String? = null,
) {
    fun prepareCalculation(): List<Number> {
        val expressions = segregateExpressions()
        return convertNumbers(expressions)
    }

    private fun segregateExpressions(): List<String> {
        if (value.isNullOrBlank()) {
            return listOf(ZERO)
        }
        val result: MatchResult? = customRegex.find(value)
        result?.let {
            val customDelimiter = it.groupValues[1]
            return it.groupValues[2].split(customDelimiter)
        }
        return value.split(DELIMITER_COMMA, DELIMITER_COLON)
    }

    private fun convertNumbers(expressions: List<String>): List<Number> {
        return expressions.map { Number(it) }
            .toList()
    }

    companion object {
        private val customRegex: Regex = Regex("//(.)\n(.*)")

        private const val DELIMITER_COMMA = ","
        private const val DELIMITER_COLON = ":"
        private const val ZERO = "0"
    }
}
