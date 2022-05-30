package calculator.domain

data class Expression(val operands: List<Operand>) {

    companion object {
        operator fun invoke(operands: List<Int>) = Expression(operands.map { Operand(it) })
    }
}
