package stringadder.domain

class Parser(input: String) {
    private val expression: String = input
    private val delimiters: Delimiters = Delimiters(input)

    fun getOperands(): List<Int> {
        return expression.split(*delimiters.list.toTypedArray()).map { token -> token.toInt() }
    }
}