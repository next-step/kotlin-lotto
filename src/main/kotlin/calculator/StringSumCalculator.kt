package calculator

class StringSumCalculator {
    fun calculate(input: String?): Int {
        val expression = Expression.from(expression = input)
        val operandGroup = OperandTokenizer.tokenize(expression = expression)
        return operandGroup.sum()
    }
}
