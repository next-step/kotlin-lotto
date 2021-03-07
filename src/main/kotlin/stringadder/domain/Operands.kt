package stringadder.domain

class Operands(val operands: List<Operand>) {
    fun sum() = operands.map { it.operand }.sum()
}
