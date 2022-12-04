package calculator

class StringPlusCalculator {
    fun calculate(input: String?): Int {
        val expression = Expression.from(expression = input)
        val expressionSplitter = ExpressionSlitterFactory.create(expression = expression)
        val splitted = expressionSplitter.split(expression = expression)
        val operands = splitted.map { Operand.from(it) }
        return operands.fold(0) { acc, operand -> acc + operand.value }
    }
}
