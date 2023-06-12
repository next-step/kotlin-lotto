package calculator.stringcalculator.splitter

class CustomDelimiterSplitter(private val delimiter: Regex) : StringSplitter() {

    override fun supported(input: String): Boolean = delimiter.matches(input)

    override fun split(input: String): List<String> =
        if (input.isBlank()) DEFAULT_RETURN_VALUE
        else findDelimiterAndInput(input).let {
            it.second.split(it.first).map { operand -> operand.trim() }
        }

    private fun findDelimiterAndInput(input: String): Pair<String, String> =
        delimiter.find(input)?.let {
            val (_, delimiter, operands) = it.groupValues

            return delimiter to operands
        } ?: throw IllegalArgumentException("$INVALID_VALUE_MESSAGE $input")

    companion object {
        private const val INVALID_VALUE_MESSAGE = "Invalid Value:"
        private val DEFAULT_RETURN_VALUE: List<String> = emptyList()
    }
}
