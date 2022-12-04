package calculator

object OperandTokenizer {
    fun tokenize(expression: Expression): List<Operand> {
        val splitter = ExpressionSlitterFactory.create(expression = expression)
        return splitter.split(expression = expression)
            .map { Operand.from(expression = it) }
    }
}
