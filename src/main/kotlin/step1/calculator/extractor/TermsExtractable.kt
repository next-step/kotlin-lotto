package step1.calculator.extractor

import step1.calculator.domain.ExpressionType
import step1.calculator.domain.Terms

interface TermsExtractable {
    fun extractTerms(expressionType: ExpressionType, expression: String): Terms
}
