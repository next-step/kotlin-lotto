package calculator.domain

object AdditionCalculator : Calculator {

    override fun calculate(operands: Operands): Int {
        return operands.sumOf()
    }
}
