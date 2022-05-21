package expressioncalculator.model

data class ExpressionInput(
    val expression: Expression,
    val delimiter: Delimiter
) {
    companion object {
        private const val DEFAULT_DELIMITER_REGEX_PATTERN = "[,:]"
        private val defaultDelimiter = DEFAULT_DELIMITER_REGEX_PATTERN.toRegex()

        fun from(expression: Expression): ExpressionInput {
            return ExpressionInput(
                expression = expression,
                delimiter = Delimiter(defaultDelimiter)
            )
        }
    }
}
