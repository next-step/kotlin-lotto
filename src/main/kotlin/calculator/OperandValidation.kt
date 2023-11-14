package calculator

fun interface OperandValidation {
    fun check(input: Operand): Boolean
}
