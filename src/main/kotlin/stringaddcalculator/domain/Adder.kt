package stringaddcalculator.domain

class Adder {
    fun add(operands: List<Operand>): Int {
        return operands.sumOf { it.value }
    }
}
