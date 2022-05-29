package advancedcalculate.domain

sealed class Delimiter {
    abstract fun extractOperands(calculateInput: String): List<Operand>

    companion object {
        fun from(calculateInput: String): Delimiter =
            when (CustomDelimiter.CUSTOM_DELIMITER_REGEX.matches(calculateInput)) {
                true -> CustomDelimiter(calculateInput)
                false -> DefaultDelimiter()
            }
    }
}
