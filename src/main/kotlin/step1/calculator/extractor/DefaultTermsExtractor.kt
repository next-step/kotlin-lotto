package step1.calculator.extractor

import step1.calculator.DelimiterType

class DefaultTermsExtractor : TermsExtractable {
    override fun extractTerms(delimiterType: DelimiterType, expression: String): List<String> =
        delimiterType.toRegex().split(expression)
}
