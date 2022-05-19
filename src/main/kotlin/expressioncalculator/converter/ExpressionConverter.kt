package expressioncalculator.converter

interface ExpressionConverter {
    fun convert(expression: String): List<Int>
}
