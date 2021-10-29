package calculator.domain

class AdditionCalculator: Calculator {

    override fun calculate(operands: Operands): Int {
        return operands.values.sumOf { it.value }
    }
}
