package calculator

class StringSeparator : Separator {
    override fun separate(expression: String): List<Int> {
        return REGEX.find(expression)?.let {
            val customDelimiter = it.groupValues[1]
            getExpressionAfterFinalDelimiter(expression)
                ?.split(customDelimiter)
                ?.map { token -> token.toInt() } ?: emptyList()
        } ?: expression.split(*DEFAULT_DELIMITERS.toTypedArray())
            .map { token -> token.toInt() }
    }

    private fun getExpressionAfterFinalDelimiter(expression: String) =
        Regex("$END_DELIMITER(.*)").find(expression)
            ?.groupValues?.get(1)

    companion object {
        val DEFAULT_DELIMITERS = listOf(",", ":")
        private const val START_DELIMITER = "//"
        private const val END_DELIMITER = "\\n"
        val REGEX = "$START_DELIMITER(.)$END_DELIMITER(.*)".toRegex()
    }
}