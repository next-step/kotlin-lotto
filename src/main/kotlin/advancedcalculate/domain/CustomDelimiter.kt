package advancedcalculate.domain

class CustomDelimiter(private val calculateInput: String) : Delimiter() {
    val customDelimiter: String

    init {
        customDelimiter = extractCustomDelimiter()
    }

    override fun extractOperands(): List<Operand> {
        val rawOperands = OPERANDS_PARSE_REGEX.replace(calculateInput, "")

        return rawOperands.split(customDelimiter)
            .map { mapOperand(it) }
            .toList()
    }

    private fun mapOperand(input: String): Operand {
        if (input.isBlank()) {
            return Operand()
        }
        return Operand(input.toDouble())
    }

    private fun extractCustomDelimiter(): String = CUSTOM_DELIMITER_PARSE_REGEX.replace(calculateInput, "")

    companion object {
        val CUSTOM_DELIMITER_REGEX = Regex("""//.\\n.*""")
        private val CUSTOM_DELIMITER_PARSE_REGEX = Regex("""//|\\n.*""")
        private val OPERANDS_PARSE_REGEX = Regex("""//.\\n""")
    }
}
