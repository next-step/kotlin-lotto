package step1.calculator.extractor

import step1.calculator.domain.DelimiterType
import step1.calculator.domain.Terms

class CustomTermsExtractor : TermsExtractable {
    override fun extractTerms(delimiterType: DelimiterType, expression: String): Terms {
        val matchResult = extractMatchResult(delimiterType, expression)
        val customDelimiter = extractGroupValues(matchResult, DELIMITER_INDEX)
        val terms = extractGroupValues(matchResult, TERMS_INDEX)

        return Terms.of(terms.split(customDelimiter))
    }

    private fun extractMatchResult(delimiterType: DelimiterType, expression: String): MatchResult =
        delimiterType.find(expression)

    private fun extractGroupValues(matchResult: MatchResult, index: Int): String = matchResult.groupValues[index]

    companion object {
        private const val DELIMITER_INDEX = 1
        private const val TERMS_INDEX = 2
    }
}
