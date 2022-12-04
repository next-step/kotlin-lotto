package calculator

class ExpressionSplitter {
    fun split(expression: Expression): List<String> {
        return expression.value.split(",|:".toRegex())
    }
}
