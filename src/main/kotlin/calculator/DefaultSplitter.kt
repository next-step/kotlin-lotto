package calculator

class DefaultSplitter : ExpressionSplitter {
    override fun split(expression: Expression): List<String> {
        return expression.value.split(",|:".toRegex())
    }
}
