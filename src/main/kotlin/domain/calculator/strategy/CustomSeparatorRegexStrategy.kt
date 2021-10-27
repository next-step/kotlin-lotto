package domain.calculator.strategy

object CustomSeparatorRegexStrategy : RegexStrategy {
    const val SEPARATOR_REGEX = "//(.)\n(.*)"

    override fun check(expression: String): Boolean = (matchResult(expression) != null)

    override fun groupValue(expression: String, index: Int): String {
        val result = matchResult(expression) ?: throw RuntimeException("")
        return result.groupValues[index]
    }

    private fun matchResult(expression: String): MatchResult? = Regex(SEPARATOR_REGEX).find(expression)
}
