package stringadder.domain

class Delimiters(vararg delimiter: String = emptyArray()) {
    val delimiters: List<String> = listOf(",", ":", *delimiter)

    fun delimit(expression: String): List<Operand> {
        return expression.split(*delimiters.toTypedArray()).map { Operand(it) }
    }
}
