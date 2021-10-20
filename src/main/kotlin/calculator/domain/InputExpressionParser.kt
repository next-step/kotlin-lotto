package calculator.domain

class InputExpressionParser {
    fun parse(input: String): Operands {
        val parsedInput = parseByCustomDelimiter(input) ?: parseByDefaultDelimiter(input)
        return Operands.from(parsedInput)
    }

    private fun parseByCustomDelimiter(input: String): List<String>? {
        val matchResult = Regex(CUSTOM_DELIMITER_PATTERN).find(input)

        matchResult?.let {
            val (customDelimiter, parsedInput) = it.destructured
            return parsedInput.split(customDelimiter)
        }

        return null
    }

    private fun parseByDefaultDelimiter(input: String): List<String> {
        return input.split(*DEFAULT_DELIMITERS.toTypedArray())
    }

    companion object {
        private const val CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)"
        private val DEFAULT_DELIMITERS = listOf(",", ":")
    }
}
