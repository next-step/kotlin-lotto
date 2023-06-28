package calculator

class OperandCollection(
    private val operands: List<Operand>
) {

    fun add(): Int {
        return this.operands.sumOf { it.operand.toInt() }
    }

    companion object {
        fun of(stringNumbers: List<String>): OperandCollection {
            return OperandCollection(stringNumbers.map { Operand(it) })
        }
    }
}
