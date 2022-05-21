package expressioncalculator.model

data class ExpressionInput(
    val expression: Expression,
    val delimiter: Delimiter
) {
    companion object {
        fun from(expression: String): ExpressionInput {
            return ExpressionInput(
                expression = Expression(expression),
                delimiter = Delimiter("[,:]".toRegex())
            )
        }
    }
}
