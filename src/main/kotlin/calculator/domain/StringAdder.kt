package calculator.domain

class StringAdder(
    private val separator: Separator
) {
    fun calculate(expression: String): Long {
        if (isBlankExpression(expression)) {
            return 0
        }

        return separator
            .separate(expression)
            .sum()
    }

    private fun isBlankExpression(expression: String): Boolean {
        return expression.isBlank() || expression.endsWith("\n")
    }
}
