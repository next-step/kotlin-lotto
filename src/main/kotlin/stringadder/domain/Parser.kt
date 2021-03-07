package stringadder.domain

class Parser(private val input: String) {
    var operands: Operands = Operands(emptyList())
    private var delimiters: List<String> = DEFAULT_DELIMITERS

    init {
        initWithCustomDelimiter()
        initWithoutCustomDelimiter()
    }

    private fun initWithoutCustomDelimiter() {
        if (!hasCustomDelimiter()) {
            operands = Operands(
                input.split(*delimiters.toTypedArray())
                    .map { token -> Operand(token) }
            )
        }
    }

    private fun initWithCustomDelimiter() {
        if (hasCustomDelimiter()) {
            delimiters = DEFAULT_DELIMITERS + listOf(input[DELIMITER_INDEX].toString())
            operands = initOperands()
        }
    }

    private fun hasCustomDelimiter() =
        input.startsWith(DELIMITER_PREFIX) && input.startsWith(DELIMITER_SUFFIX, SUFFIX_START_INDEX)

    private fun initOperands(): Operands {
        val expression = input.substring(EXPRESSION_START_INDEX)
        return Operands(expression.split(*delimiters.toTypedArray()).map { token -> Operand(token) })
    }

    companion object {
        private val DEFAULT_DELIMITERS = listOf(",", ":")
        private const val DELIMITER_PREFIX = "//"
        private const val DELIMITER_SUFFIX = "\\n"
        private const val SUFFIX_START_INDEX = 3
        private const val DELIMITER_INDEX = 2
        private const val EXPRESSION_START_INDEX = 5
    }
}
