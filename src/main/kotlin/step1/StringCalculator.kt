package step1

class StringCalculator(private val expressionParser: ExpressionParser) {

    fun calculate(expression: String?): Int {
        val (operands, operators) = expressionParser.parse(expression)
        return calculate(operands, operators)
    }

    private fun calculate(operands: List<Int>, operators: List<Operator>): Int {
        return operators.zip(operands.drop(1))
            .fold(operands.first()) { accumulator, (operator, operand) ->
                operator.execute(accumulator, operand)
            }
    }
}
