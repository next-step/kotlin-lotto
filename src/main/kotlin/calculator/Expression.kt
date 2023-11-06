package calculator

class Expression(private val expression: String) {
    val isBlank: Boolean
        get() = expression.isBlank()

    fun delimiter(): Array<String> {
        if (hasCustomrDelimiter()) {
            val result = CUSTOM_DELIMITER.findAll(expression).first()
            return arrayOf(result.groupValues[1])
        }
        return DEFAULT_DELIMITER
    }

    fun parsedExpression(): String {
        return if (hasCustomrDelimiter()) expression.replace(CUSTOM_DELIMITER, "")
        else expression.trim()
    }

    private fun hasCustomrDelimiter() = expression.contains(CUSTOM_DELIMITER)

    override fun toString(): String {
        return expression
    }

    companion object {
        private val CUSTOM_DELIMITER = Regex("^//(.+)\n")
        private val DEFAULT_DELIMITER = arrayOf(",", ":")
    }
}
