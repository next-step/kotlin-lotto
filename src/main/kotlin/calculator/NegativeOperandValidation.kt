package calculator

class NegativeOperandValidation : OperandValidation {
    override fun check(input: Operand): Boolean = input < Operand.ZERO
}
