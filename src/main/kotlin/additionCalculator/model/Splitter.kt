package additionCalculator.model

private val CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)".toRegex()
private val DEFAULT_DELIMITER_REGEX = "[,:]".toRegex()

object Splitter {
    fun split(expression: String?): List<String> {
        if (expression.isNullOrBlank()) {
            return emptyList()
        }
        return CUSTOM_DELIMITER_REGEX.find(expression)?.let {
            it.groupValues[2].split(it.groupValues[1])
        } ?: run {
            getDefaultDelimiterTokens(expression)
        }
    }

    private fun getDefaultDelimiterTokens(expression: String): List<String> {
        return expression.split(DEFAULT_DELIMITER_REGEX)
    }
}
