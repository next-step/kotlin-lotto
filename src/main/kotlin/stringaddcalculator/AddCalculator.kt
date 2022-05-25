package stringaddcalculator

class AddCalculator {
    fun calculate(expression: Expression): Int {
        return expression.parse().reduce { sum, operand -> sum + operand }
    }
}
