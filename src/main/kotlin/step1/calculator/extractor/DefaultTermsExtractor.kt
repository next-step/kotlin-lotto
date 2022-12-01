package step1.calculator.extractor

import step1.calculator.domain.DelimiterType
import step1.calculator.domain.Terms

class DefaultTermsExtractor : TermsExtractable {
    override fun extractTerms(delimiterType: DelimiterType, expression: String): Terms =
        Terms.of(delimiterType.toRegex().split(expression))
}
