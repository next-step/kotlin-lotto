package expressioncalculator.model

data class ExpressionInput(
    val expression: Expression,
    val delimiter: Delimiter
) {
    companion object {
        private const val DEFAULT_DELIMITER_REGEX_PATTERN = "[,:]"

        fun from(expression: Expression): ExpressionInput {
            return ExpressionInput(
                expression = expression,
                delimiter = Delimiter(DEFAULT_DELIMITER_REGEX_PATTERN)
            )
        }
    }
}
