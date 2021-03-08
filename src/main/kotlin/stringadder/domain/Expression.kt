package stringadder.domain

class Expression(delimiters: Delimiters, expression: String) {
    private val operands: Operands = Operands(delimiters.delimit(expression))

    fun result() = operands.sum()
}
