package calculator

object OperandTokenizer {
    fun tokenize(expression: Expression): OperandGroup {
        val splitter = ExpressionSlitterFactory.create(expression = expression)
        val operands = splitter.split(expression = expression)
            .map { Operand.from(expression = it) }
        return OperandGroup(operands = operands)
    }
}
