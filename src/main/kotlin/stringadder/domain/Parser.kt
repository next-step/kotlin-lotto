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
            delimiters = DEFAULT_DELIMITERS + CUSTOM_DELIMITER_PATTERN.find(input)?.groupValues!![1]
            operands = initOperands()
        }
    }

    private fun hasCustomDelimiter() = CUSTOM_DELIMITER_PATTERN.matches(input)

    private fun initOperands(): Operands {
        val expression = CUSTOM_DELIMITER_PATTERN.find(input)?.groupValues!![2]
        return Operands(expression.split(*delimiters.toTypedArray()).map { token -> Operand(token) })
    }

    companion object {
        private val DEFAULT_DELIMITERS = listOf(",", ":")
        private val CUSTOM_DELIMITER_PATTERN = Regex("//(.*)\\\\n(.*)")
    }
}
