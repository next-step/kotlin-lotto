package calculator

class ExpressionParser {
    fun parse(expression: String): List<Int> {
        val (defaultExpression, customOperands) = expression.split(DelimiterRegex.CUSTOM.regex)
            .partition { it.contains(DelimiterRegex.DEFAULT.regex) }

        val defaultOperands = defaultExpression.asSequence()
            .flatMap { it.split(DelimiterRegex.DEFAULT.regex) }
            .map { getOperandValue(it) }
            .toList()

        return listOf(defaultOperands, customOperands.map { getOperandValue(it) }).flatten()
    }

    private fun getOperandValue(operand: String): Int {
        if (operand.isBlank()) return 0
        if (!operand.all { it.isDigit() }) throw RuntimeException("피연산자는 양수만 가능합니다")
        return operand.toInt()
    }
}
