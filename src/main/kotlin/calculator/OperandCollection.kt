package calculator

class OperandCollection(
    private val operands: List<Operand>
) {

    constructor(stringNumbers: List<String>, dummyForImplicit: Any? = null) : this(stringNumbers.map { Operand(it) })

    fun add(): Int {
        return this.operands.sumOf { it.operand.toInt() }
    }
}
