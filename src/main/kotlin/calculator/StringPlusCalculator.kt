package calculator

class StringPlusCalculator {
    fun calculate(input: String?): Int {
        val expression = Expression.from(expression = input)
        val defaultSplitter = DefaultSplitter()
        val splitted = defaultSplitter.split(expression = expression)
        val operands = splitted.map { Operand.from(it) }
        return operands.fold(0) { acc, operand -> acc + operand.value }
    }
}
