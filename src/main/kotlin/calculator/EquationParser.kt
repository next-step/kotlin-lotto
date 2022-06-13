package calculator

private const val CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)"
private const val CUSTOM_DELIMITER_INDEX = 1
private const val ORIGIN_EQUATION_INDEX = 2

object EquationParser {

    fun parse(input: String?): List<Operand> {
        if (input.isNullOrBlank()) {
            return listOf(Operand.DEFAULT)
        }
        val (equation, delimiters) = parseDelimiter(input)

        return equation.split(delimiters)
    }

    private fun parseDelimiter(input: String): Pair<Equation, List<Delimiter>> {
        val matchResult = Regex(CUSTOM_DELIMITER_REGEX).find(input) ?: return Pair(Equation(input), Delimiter.DEFAULT)

        return Pair(
            Equation(matchResult.groupValues[ORIGIN_EQUATION_INDEX]),
            listOf(Delimiter(matchResult.groupValues[CUSTOM_DELIMITER_INDEX]))
        )
    }
}
