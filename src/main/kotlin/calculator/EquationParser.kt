package calculator

object EquationParser {

    fun parse(input: String): List<Operand> {
        if (input.isBlank()) {
            return listOf(Operand.DEFAULT)
        }
        return input.split(",", ":").map { Operand.from(it) }
    }
}
