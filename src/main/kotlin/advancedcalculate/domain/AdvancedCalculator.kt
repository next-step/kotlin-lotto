package advancedcalculate.domain

class AdvancedCalculator(calculateInput: String) {
    private val delimiter: Delimiter
    private val operands: List<Operand>

    init {
        delimiter = Delimiter.from(calculateInput)
        operands = delimiter.extractOperands()
    }

    fun calculate(): Double {
        if (operands.isEmpty()) {
            return 0.0
        }

        return operands.reduce { operand1, operand2 -> operand1 + operand2 }.value
    }
}
