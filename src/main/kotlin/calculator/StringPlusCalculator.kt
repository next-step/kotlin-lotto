package calculator

class StringPlusCalculator {
    fun calculate(input: String?): Int {
        val expression = Expression.from(expression = input)
        val operands = OperandTokenizer.tokenize(expression = expression)
        return operands.fold(0) { acc, operand -> acc + operand.value }
    }
}
