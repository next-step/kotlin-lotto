package advancedcalculate.domain

class DefaultDelimiter(private val calculateInput: String) : Delimiter() {
    override fun extractOperands(): List<Operand> {
        if (calculateInput.isBlank()) {
            return emptyList()
        }

        return DEFAULT_OPERANDS_PARSE_REGEX.split(calculateInput)
            .map { Operand(it.toDouble()) }
            .toList()
    }

    companion object {
        val DEFAULT_OPERANDS_PARSE_REGEX = Regex("[,;]")
    }
}
