package calculator.domain

class Calculator(private val expression: Expression) {

    fun calculate(): Int {
        val operands = expression.value.mapNotNull { it as? ExpressionElement.OperandElement }
        val operators = expression.value.mapNotNull { it as? ExpressionElement.OperatorElement }

        return operands.reduceIndexed { index, acc, operandElement ->
            ExpressionElement.OperandElement(
                operators[index - BUFFER_OPERATOR]
                    .value
                    .calculator(acc.value, operandElement.value)
            )
        }.value
    }

    companion object {
        private const val BUFFER_OPERATOR = 1
    }
}
