package calculator

object EquationParser {

    fun parse(input: String): List<Operand> {
        if (input.isBlank()) {
            return listOf(Operand(0))
        }
        return input.split(",", ":").map { Operand(it.toInt()) }
    }
}
