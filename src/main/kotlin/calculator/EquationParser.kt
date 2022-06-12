package calculator

object EquationParser {

    fun parse(input: String?): List<Operand> {
        if (input.isNullOrBlank()) {
            return listOf(Operand.DEFAULT)
        }
        val (equation, delimiters) = parseDelimiter(input)

        return equation.split(delimiters)
    }

    private fun parseDelimiter(input: String): Pair<Equation, List<Delimiter>> {
        val matchResult = Regex("//(.)\n(.*)").find(input) ?: return Pair(Equation(input), Delimiter.DEFAULT)

        return Pair(Equation(matchResult.groupValues[2]), listOf(Delimiter(matchResult.groupValues[1])))
    }
}
