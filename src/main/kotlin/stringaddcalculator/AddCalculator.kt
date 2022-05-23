package stringaddcalculator

class AddCalculator {
    fun calculate(expression: String?): Int {
        if (expression.isNullOrBlank())
            return 0

        return expression
            .split(",", ":")
            .map { it.trim().toInt() }
            .reduce { sum, operand -> sum + operand }
    }
}
