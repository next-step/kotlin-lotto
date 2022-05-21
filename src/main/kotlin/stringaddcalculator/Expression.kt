package stringaddcalculator

class Expression(var formula: String) {
    lateinit var operands: List<Int>

    fun parse() {
        val regexFindResult = Regex(CUSTOM_DELIMITER).find(formula)

        if(regexFindResult != null) {
            val customDelimiter = regexFindResult.groupValues[1]
            val expression = regexFindResult.groupValues[2]
            val delimitersRegex = (listOf(customDelimiter) + DEFAULT_DELIMITER).joinToString("|").toRegex()

            operands = expression.split(delimitersRegex).map { it.toPositiveIntOrThrow() }
            return
        }

        operands = formula.split(DEFAULT_DELIMITER.joinToString("|").toRegex()).map { it.toPositiveIntOrThrow() }
    }

    private fun String.toIntOrThrow() = requireNotNull(toIntOrNull()) { "올바른 계산식이 아닙니다." }

    private fun String.toPositiveIntOrThrow(): Int {
        val number = toIntOrThrow()

        require(number > 0) { "음수는 계산 할 수 없습니다." }

        return number
    }

    companion object {
        private val DEFAULT_DELIMITER = listOf(":", ",")

        private const val CUSTOM_DELIMITER = "//(.)\n(.*)"
    }
}