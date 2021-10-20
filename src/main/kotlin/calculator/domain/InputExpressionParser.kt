package calculator.domain

class InputExpressionParser {
    fun parse(input: String?): Operands {
        if (input.isNullOrBlank()) {
            return OPERANDS_OF_ZERO
        }

        val parsedInput = parseByCustomDelimiter(input) ?: parseByDefaultDelimiter(input)
        return Operands.from(parsedInput)
    }

    private fun parseByCustomDelimiter(input: String): List<String>? {
        val found = Regex(CUSTOM_DELIMITER_PATTERN).find(input)

        found?.let {
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
        private val OPERANDS_OF_ZERO = Operands.from(listOf("0"))
    }
}
