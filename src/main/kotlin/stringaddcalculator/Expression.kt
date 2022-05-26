package stringaddcalculator

object Expression {
    fun parse(formula: String): List<Int> {
        val regexFindResult = Regex(CUSTOM_DELIMITER).find(formula)

        if (regexFindResult != null) {
            val customDelimiter = regexFindResult.groupValues[1]
            val expression = regexFindResult.groupValues[2]
            val delimitersRegex = (listOf(customDelimiter) + DEFAULT_DELIMITER).joinToString("|").toRegex()

            return expression.split(delimitersRegex).map { it.toPositiveIntOrThrow() }
        }

        return formula.split(DEFAULT_DELIMITER.joinToString("|").toRegex()).map { it.toPositiveIntOrThrow() }
    }

    private fun String.toIntOrThrow() = requireNotNull(toIntOrNull()) { "올바른 계산식이 아닙니다." }

    private fun String.toPositiveIntOrThrow(): Int {
        val number = toIntOrThrow()

        require(number > 0) { "음수는 계산 할 수 없습니다." }

        return number
    }

    private val DEFAULT_DELIMITER = listOf(":", ",")

    private const val CUSTOM_DELIMITER = "//(.)\n(.*)"
}
