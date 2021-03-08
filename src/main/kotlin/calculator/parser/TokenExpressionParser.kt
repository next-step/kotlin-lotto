package calculator.parser

class TokenExpressionParser(vararg tokens: String = arrayOf(",")) : ExpressionParser {
    private val tokens = arrayOf(*tokens)

    override fun support(expression: String): Boolean = tokens.any { expression.contains(it) }

    override fun parse(expression: String): List<String> {
        return expression.split(*tokens)
    }
}
