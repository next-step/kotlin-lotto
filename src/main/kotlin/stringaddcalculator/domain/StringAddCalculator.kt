package stringaddcalculator.domain

class StringAddCalculator {
    fun calculate(expression: String?): Int {
        if (expression.isNullOrBlank()) return 0
        return 1
    }
}
