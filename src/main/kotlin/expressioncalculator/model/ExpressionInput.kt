package expressioncalculator.model

data class ExpressionInput(
    val expression: String,
    val delimiter: Delimiter
) {
    companion object {
        fun from(expression: String): ExpressionInput {
            return ExpressionInput(
                expression = expression,
                delimiter = Delimiter("[,:]".toRegex())
            )
        }
    }
}
