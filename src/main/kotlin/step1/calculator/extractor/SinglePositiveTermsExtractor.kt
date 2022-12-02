package step1.calculator.extractor

import step1.calculator.domain.ExpressionType
import step1.calculator.domain.Terms

class SinglePositiveTermsExtractor : TermsExtractable {
    override fun extractTerms(expressionType: ExpressionType, expression: String): Terms =
        Terms.singleNumberTerms(expression)
}
