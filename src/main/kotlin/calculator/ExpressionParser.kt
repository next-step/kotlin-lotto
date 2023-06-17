package calculator

object ExpressionParser {
    fun parse(expression: String): List<Int> {
        val (defaultExpression, customOperands) = expression.split(DelimiterRegex.CUSTOM.regex)
            .partition { it.contains(DelimiterRegex.DEFAULT.regex) }

        val defaultOperands = defaultExpression.asSequence()
            .flatMap { it.split(DelimiterRegex.DEFAULT.regex) }
            .map { getOperaPositiveValue(it) }
            .toList()

        return listOf(defaultOperands, customOperands.map { getOperaPositiveValue(it) }).flatten()
    }

    private fun getOperaPositiveValue(operand: String): Int {
        if (operand.isBlank()) return 0
        if (!operand.all { it.isDigit() }) throw RuntimeException("피연산자는 양수만 가능합니다")
        return operand.toInt()
    }
}
