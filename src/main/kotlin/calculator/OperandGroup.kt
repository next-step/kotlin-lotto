package calculator

class OperandGroup(val operands: List<Operand>) {
    fun sum(): Int {
        return operands.fold(0) { acc, operand -> acc + operand.value }
    }
}
