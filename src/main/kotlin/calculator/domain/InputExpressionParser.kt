package calculator.domain

class InputExpressionParser {
    fun parse(input: String): Operands {
        val parsedInput = parseByDelimiter(input)
        return Operands.from(parsedInput)
    }

    private fun parseByDelimiter(input: String): List<String> {
        val matchResult = CUSTOM_REGEX.find(input)

        matchResult?.let {
            val (customDelimiter, parsedInput) = it.destructured
            return parsedInput.split(customDelimiter)
        }

        return input.split(*DEFAULT_DELIMITERS.toTypedArray())
    }

    companion object {
        private val CUSTOM_REGEX = Regex("//(.)\n(.*)")
        private val DEFAULT_DELIMITERS = listOf(",", ":")
    }
}
