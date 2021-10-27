package calculator.domain

class Expression private constructor(
    private val value: String? = null,
) {
    fun segregateExpressions(): List<Number> {
        if (value.isNullOrBlank()) {
            return listOf(Number(ZERO))
        }
        val result: MatchResult? = customRegex.find(value)
        result?.let { it ->
            val customDelimiter = it.groupValues[1]
            return convertNumbers(it.groupValues[2].split(customDelimiter))
        }
        return convertNumbers(value.split(DELIMITER_COMMA, DELIMITER_COLON))
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

        fun from(input: String?): List<Number> {
            return Expression(input).segregateExpressions()
        }
    }
}
