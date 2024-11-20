package calculator

object SeparatorSelector {

    private val defaultSeparatorRegex = "[,:]".toRegex()
    private val customSeparatorParseRegex = "//(.)\n(.*)".toRegex()

    fun select(expression: String): SeparatorSelectResult {
        return customSeparatorParseRegex.find(expression)
            ?.let { parseCustomSeparator(it) }
            ?: SeparatorSelectResult(defaultSeparatorRegex, expression)
    }

    private fun parseCustomSeparator(matchResult: MatchResult): SeparatorSelectResult {
        val customDelimiter = matchResult.groupValues[1]
        val expressionExceptCustomSeparator = matchResult.groupValues[2]
        return SeparatorSelectResult(customDelimiter.toRegex(), expressionExceptCustomSeparator)
    }

}
