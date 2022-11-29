package step1.calculator.extractor

import step1.calculator.DelimiterType

class DefaultExpressionParser : ExpressionParser {
    override fun extractTerms(delimiterType: DelimiterType, expression: String): List<String> =
        delimiterType.toRegex().split(expression)
}
