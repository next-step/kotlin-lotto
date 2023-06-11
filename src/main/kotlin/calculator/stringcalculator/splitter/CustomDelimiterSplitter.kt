package calculator.stringcalculator.splitter

object CustomDelimiterSplitter : Splitter<String, List<String>> {
    private const val INVALID_VALUE_MESSAGE = "Invalid Value:"
    private const val DELIMITER_INDEX = 1
    private const val OPERANDS_INDEX = 2
    private val DELIMITER = Regex("//([^0-9])\n(.*)")
    private val DEFAULT_RETURN_VALUE = listOf("")

    override fun split(input: String): List<String> {
        if (input.isBlank()) {
            return DEFAULT_RETURN_VALUE
        }
        return findDelimiterAndInput(input).let {
            it.second.split(it.first).map { operand -> operand.trim() }
        }
    }

    private fun findDelimiterAndInput(input: String): Pair<String, String> {
        return DELIMITER.find(input)?.let {
            val (_, delimiter, operands) = it.groupValues

            return Pair(delimiter, operands)
        } ?: throw IllegalArgumentException("$INVALID_VALUE_MESSAGE $input")
    }
}
