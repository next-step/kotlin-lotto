package domain

object ExpressionFactory {
    private val DEFAULT_SEPARATORS = "[,:]".toRegex()
    private val DEFAULT_EXPRESSION_TOKEN = listOf("0")
    private val CUSTOM_DELIMITER_PATTERN = Regex("//(.)\n(.*)")

    fun createExpression(input: String?): Expression =
        parseExpression(
            if (input.isNullOrEmpty()) {
                DEFAULT_EXPRESSION_TOKEN
            } else {
                getTokens(input)
            }
        )

    private fun getTokens(input: String): List<String> {
        val result = CUSTOM_DELIMITER_PATTERN.find(input)
        return result?.let {
            val customDelimiter = it.groupValues[1]
            require(customDelimiter.isNotEmpty()) { "커스텀 구분자가 비어있습니다." }
            it.groupValues[2].split(customDelimiter)
        } ?: input.split(DEFAULT_SEPARATORS)
    }

    private fun parseExpression(terms: List<String>): Expression {
        return Expression(terms.map { Term(it) })
    }
}
