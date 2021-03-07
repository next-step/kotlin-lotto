package stringadder.domain

class Expression(delimiters: Delimiters, expression: String) {
    private val operands: Operands = Operands(expression.split(*delimiters.list.toTypedArray()).map { Operand(it) })

    fun result() = operands.sum()
}
