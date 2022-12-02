package step1.calculator.extractor

import step1.calculator.domain.ExpressionType
import step1.calculator.domain.Terms

class DefaultTermsExtractor : TermsExtractable {
    override fun extractTerms(expressionType: ExpressionType, expression: String): Terms =
        Terms.of(expressionType.toRegex().split(expression))
}
