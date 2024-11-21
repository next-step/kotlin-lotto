package calculator

object SeparatorSelector {

    private const val CUSTOM_SEPARATOR_INDEX = 1
    private const val EXPRESSION_INDEX = 2

    private val defaultSeparatorRegex = "[,:]".toRegex()
    private val customSeparatorParseRegex = "//(.)\n(.*)".toRegex()

    fun select(expression: String): SeparatorSelectResult {
        return customSeparatorParseRegex.find(expression)
            ?.let { parseCustomSeparator(it) }
            ?: SeparatorSelectResult(defaultSeparatorRegex, expression)
    }

    private fun parseCustomSeparator(matchResult: MatchResult): SeparatorSelectResult {
        val customDelimiter = matchResult.groupValues[CUSTOM_SEPARATOR_INDEX]
        val expression = matchResult.groupValues[EXPRESSION_INDEX]
        return SeparatorSelectResult(customDelimiter.toRegex(), expression)
    }

}
