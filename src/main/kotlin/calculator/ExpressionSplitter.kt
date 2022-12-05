package calculator

interface ExpressionSplitter {
    fun split(expression: Expression): List<String>
}
