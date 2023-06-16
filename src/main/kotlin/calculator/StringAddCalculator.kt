package calculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (Expression.isEmptyExpression(text)) return DEFAULT_RESULT
        return calculate(Expression.getExpression(text), Delimiter.getDelimitersOfText(text))
    }

    private fun calculate(expression: String, delimiters: List<String>): Int {
        val numStringList = Expression.splitExpression(expression, delimiters)
        return calculateSum(numStringList)
    }

    private fun calculateSum(text: List<String>): Int {
        return text.sumOf { stringToPositiveInteger(it) }
    }

    private fun stringToPositiveInteger(text: String): Int {
        return PositiveInteger.getPositiveInteger(text)
    }

    companion object {
        private const val DEFAULT_RESULT = 0
    }
}