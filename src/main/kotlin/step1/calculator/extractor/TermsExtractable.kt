package step1.calculator.extractor

import step1.calculator.DelimiterType

interface TermsExtractable {
    fun extractTerms(delimiterType: DelimiterType, expression: String): List<String>
}
