package calculator.model.evaluator

import calculator.model.operator.Operator

class ExpressionEvaluator(
    private val numbers: List<Int>,
    private val operator: Operator,
) {
    fun evaluate(): Int {
        return numbers.reduce(operator::apply)
    }
}
