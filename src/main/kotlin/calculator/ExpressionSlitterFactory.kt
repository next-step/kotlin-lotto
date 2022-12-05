package calculator

object ExpressionSlitterFactory {
    fun create(expression: Expression): ExpressionSplitter {
        if (expression.hasCustomDelimiter()) {
            return CustomDelimiterSplitter
        }
        return DefaultSplitter
    }
}
