package calculator

class ExpressionSplitter {
    fun split(expression: String): List<String> {
        return expression.split(",|:".toRegex())
    }
}
