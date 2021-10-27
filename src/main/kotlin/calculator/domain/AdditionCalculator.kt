package calculator.domain

class AdditionCalculator : Calculator {
    override fun calculate(expressions: List<Number>): Int = expressions.sumOf { it.toInt() }
}
