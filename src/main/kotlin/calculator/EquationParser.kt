package calculator

object EquationParser {

    fun parse(input: String?): List<Operand> {
        if (input.isNullOrBlank()) {
            return listOf(Operand.DEFAULT)
        }
        val matchResult = Regex("//(.)\n(.*)").find(input) ?: return input.split(",", ":").map { Operand.from(it) }

        val customDelimiter = matchResult.groupValues[1]

        return matchResult.groupValues[2].split(customDelimiter).map { Operand.from(it) }
    }
}
