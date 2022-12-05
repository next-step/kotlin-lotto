package add_calculator

class InputParser {

    fun parse(input: String?): List<Operand> {

        if (input.isNullOrBlank()) {
            return DEFAULT_OPERANDS
        }

        val result = CUSTOM_DELEGATE_REGEXP.find(input)

        val texts: List<String> = result?.let {
            val customDelimiter = it.groupValues[1]
            it.groupValues[2].split(customDelimiter)
        } ?: input.split(DEFAULT_DELEGATE_REGEXP)

        return toOperands(texts)
    }

    private fun toOperands(texts: List<String>): List<Operand> {
        return texts.map { text ->
            Operand(text)
        }
    }

    companion object {
        private val DEFAULT_OPERANDS = listOf(Operand("0"))
        private const val DEFAULT_DELEGATE_PATTERN = ",|:"
        private val DEFAULT_DELEGATE_REGEXP = Regex(DEFAULT_DELEGATE_PATTERN)

        private const val CUSTOM_DELEGATE_PATTERN = "//(.)\n(.*)"
        private val CUSTOM_DELEGATE_REGEXP = Regex(CUSTOM_DELEGATE_PATTERN)
    }
}
