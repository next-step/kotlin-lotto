package calculator

object StringSeparator : Separator {

    private val DEFAULT_DELIMITERS = listOf(",", ":")
    private const val START_DELIMITER = "//"
    private const val END_DELIMITER = "\\n"
    private val REGEX = "$START_DELIMITER(.)$END_DELIMITER(.*)".toRegex()

    override fun separate(expression: String): List<Int> {
        return REGEX.find(expression)?.let {
            val customDelimiter = it.groupValues[1]
            getExpressionAfterEndDelimiter(expression)
                ?.split(customDelimiter)
                ?.map { token -> token.toInt() } ?: emptyList()
        } ?: expression.split(*DEFAULT_DELIMITERS.toTypedArray())
            .map { token -> token.toInt() }
    }

    private fun getExpressionAfterEndDelimiter(expression: String) =
        Regex("$END_DELIMITER(.*)").find(expression)
            ?.groupValues
            ?.get(1)
}
