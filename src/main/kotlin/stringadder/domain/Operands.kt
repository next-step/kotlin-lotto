package stringadder.domain

class Operands(private val operands: List<Operand>) {
    fun sum() = operands.map { it.operand }.sum()
}
