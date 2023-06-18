package stringcalculator.entity

class Formula private constructor(
    val delimiter: Regex = DEFAULT_DELIMITER_REGEX,
    val expression: String,
) {
    init {
        expression.split(delimiter).map { it.toInt() }.forEach { if (it < 0) throw RuntimeException() }
    }

    fun extractNumbers(): List<String> = this.expression.split(delimiter)

    companion object {
        private val CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)".toRegex()
        private val DEFAULT_DELIMITER_REGEX = "[,:]".toRegex()
        private const val FORMULA_PATTERN_SIZE_LIMIT = 3

        fun of(input: String?): Formula {
            if (input.isNullOrEmpty()) {
                return Formula(expression = "0")
            }
            return CUSTOM_DELIMITER_REGEX.find(input)?.let {
                buildCustomDelimiterFormula(it)
            } ?: Formula(expression = input)
        }

        private fun buildCustomDelimiterFormula(matchResult: MatchResult): Formula {
            require(matchResult.groupValues.size == FORMULA_PATTERN_SIZE_LIMIT)
            val (_, customDelimiter, expression) = matchResult.groupValues
            return Formula(delimiter = customDelimiter.toRegex(), expression = expression)
        }
    }
}
