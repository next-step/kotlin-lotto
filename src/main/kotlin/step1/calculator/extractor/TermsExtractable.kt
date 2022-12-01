package step1.calculator.extractor

import step1.calculator.DelimiterType
import step1.calculator.Terms

interface TermsExtractable {
    fun extractTerms(delimiterType: DelimiterType, expression: String): Terms
}
