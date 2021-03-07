package stringadder.domain

class Expression(private val delimiters: Delimiters, private val expression: String) {
    private val operands: Operands = Operands(expression.split(*delimiters.list.toTypedArray()).map { Operand(it) })

    fun result() = operands.sum()
}
