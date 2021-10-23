package calculator.domain

class Expression private constructor(
    private val value: String? = null,
) {
    fun segregateExpressions(): List<String> {
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

    companion object {
        private val customRegex: Regex = Regex("//(.)\n(.*)")

        private const val DELIMITER_COMMA = ","
        private const val DELIMITER_COLON = ":"
        private const val ZERO = "0"

        fun from(input: String?): List<String> {
            return Expression(input).segregateExpressions()
        }
    }
}
