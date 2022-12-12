package calculator.domain

class Calculator(private val expression: Expression) {

    fun calculate(): Int {
        if (expression.value.isEmpty()) {
            return EMPTY_CALCULATE_RESULT
        }

        val operands = expression.fetchOperands()
        val operators = expression.fetchOperators()

        return operands.reduceIndexed { index, acc, operand ->
            operators[index - BUFFER_OPERATOR].calculator(acc, operand)
        }
    }

    companion object {
        private const val BUFFER_OPERATOR = 1
        private const val EMPTY_CALCULATE_RESULT = 0
    }
}
