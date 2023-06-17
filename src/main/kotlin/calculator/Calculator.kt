package calculator

class Calculator {
    fun plusAll(expression: Expression): Int {
        return expression.numbers.sumOf { it.value }
    }
}
