package calculator.domain

object ExpressionFactory {
    private val DEFAULT_EXPRESSION_TOKEN = listOf("0")

    fun createExpression(input: String?): Expression {
        val target: List<String> = if (input.isNullOrEmpty()) DEFAULT_EXPRESSION_TOKEN else Tokenizer.getTokens(input)
        return parseExpression(target)
    }

    private fun parseExpression(terms: List<String>): Expression {
        return Expression(terms.map { Term(it) })
    }
}
