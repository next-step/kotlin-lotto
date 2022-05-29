package advancedcalculate.domain

class DefaultDelimiter : Delimiter() {
    override fun extractOperands(calculateInput: String): List<Operand> {
        return DEFAULT_DELIMITERS_PARSE_REGEX.split(calculateInput)
            .map { Operand(it.toDouble()) }
            .toList()
    }

    companion object {
        val DEFAULT_DELIMITERS_PARSE_REGEX = Regex("[,;]")
    }
}
