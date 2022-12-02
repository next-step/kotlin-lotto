package step1.calculator.extractor

import step1.calculator.domain.ExpressionType
import step1.calculator.domain.Terms

class EmptyTermsExtractor : TermsExtractable {
    override fun extractTerms(expressionType: ExpressionType, expression: String): Terms = Terms.zeroTerms()
}
