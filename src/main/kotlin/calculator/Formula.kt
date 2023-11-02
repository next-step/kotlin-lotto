package calculator

class Formula(private val value: String) {

    fun getTokens(): List<String> {
        val matchResult = CUSTOM_DELIMITER_SEARCH_PATTERN.find(value)

        return matchResult?.let {
            val (customDelimiter, formula) = matchResult.groupValues.drop(1)
            formula.split(customDelimiter).toList()
        } ?: value.split(DEFAULT_DELIMITER_PATTERN)
    }

    companion object {
        private val DEFAULT_DELIMITER_PATTERN: Regex = Regex("[,:]")
        private val CUSTOM_DELIMITER_SEARCH_PATTERN: Regex = Regex("//(.)\n(.*)")
    }
}
