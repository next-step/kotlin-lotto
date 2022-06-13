package calculator

@JvmInline
value class Equation(
    private val equation: String
) {
    fun split(delimiters: List<Delimiter>): List<Operand> {
        return equation.split(*delimiters.map { it.delimiter }.toTypedArray())
            .map { Operand.from(it) }
    }
}
