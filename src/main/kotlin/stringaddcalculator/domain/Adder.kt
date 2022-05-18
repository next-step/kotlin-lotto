package stringaddcalculator.domain

class Adder {
    fun add(operands: List<Operand>): Int {
        require(operands.isNotEmpty()) { "더할 수 있는 피연산자가 없습니다" }
        return operands.sumOf { it.value }
    }
}
