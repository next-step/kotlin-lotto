package domain

object ExpressionFactory {
    private val DEFAULT_SEPARATORS = "[,:]".toRegex()
    private val defaultExpression by lazy { listOf("0") } // 사용하지 않으면 생성하지 않음

    fun createExpression(input: String?): Expression =
        parseExpression(
            if (input.isNullOrEmpty()) {
                defaultExpression
            } else {
                input.split(DEFAULT_SEPARATORS)
            }
        )

    private fun parseExpression(terms: List<String>): Expression {
        return Expression(terms.map { Term(it) })
    }
}
