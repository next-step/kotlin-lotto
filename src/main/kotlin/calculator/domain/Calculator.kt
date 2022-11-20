package calculator.domain

class Calculator {
    fun add(operands: Array<Operand>): Operand {
        return Operand(operands.sumOf { it.value })
    }
}
