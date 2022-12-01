package step1.calculator.extractor

import step1.calculator.domain.DelimiterType
import step1.calculator.domain.Terms

interface TermsExtractable {
    fun extractTerms(delimiterType: DelimiterType, expression: String): Terms
}
