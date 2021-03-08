package calculator.parser

interface ExpressionParser {

    fun support(expression: String): Boolean

    fun parse(expression: String): List<String>
}