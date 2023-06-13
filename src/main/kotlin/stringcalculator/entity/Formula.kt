package stringcalculator.entity

class Formula private constructor(
    val delimiter: Regex = DEFAULT_DELIMITER_REGEX,
    val expression: String
) {
    companion object {
        private val CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)".toRegex()
        private val DEFAULT_DELIMITER_REGEX = "[,:]".toRegex()

        fun of(input: String?): Formula {
            if (input.isNullOrEmpty()) {
                return Formula(expression = "0")
            }
            return CUSTOM_DELIMITER_REGEX.find(input)?.let {
                buildCustomDelimiterFormula(it)
            } ?: buildDefaultDelimiterFormula(input)
        }

        private fun buildCustomDelimiterFormula(matchResult: MatchResult): Formula {
            require(matchResult.groupValues.size == 3)
            val customDelimiter = matchResult.groupValues[1].toRegex()
            val expression = matchResult.groupValues[2]
            validateExpression(expression, customDelimiter)
            return Formula(delimiter = customDelimiter, expression = expression)
        }

        private fun buildDefaultDelimiterFormula(expression: String): Formula {
            validateExpression(expression)
            return Formula(expression = expression)
        }

        private fun validateExpression(expression: String, delimiter: Regex = DEFAULT_DELIMITER_REGEX) {
            expression.split(delimiter).map { it.toInt() }.forEach { if (it < 0) throw RuntimeException() }
        }
    }
}