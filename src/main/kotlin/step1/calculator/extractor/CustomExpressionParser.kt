package step1.calculator.extractor

import step1.calculator.DelimiterType

class CustomExpressionParser : ExpressionParser {
    override fun extractTerms(delimiterType: DelimiterType, expression: String): List<String> {
        val matchResult = extractMatchResult(delimiterType, expression)
        val customDelimiter = extractGroupValues(matchResult, DELIMITER_INDEX)
        val terms = extractGroupValues(matchResult, TERMS_INDEX)

        return terms.split(customDelimiter)
    }

    private fun extractMatchResult(delimiterType: DelimiterType, expression: String): MatchResult =
        delimiterType.find(expression)

    private fun extractGroupValues(matchResult: MatchResult, index: Int): String = matchResult.groupValues[index]

    companion object {
        private const val DELIMITER_INDEX = 1
        private const val TERMS_INDEX = 2
    }
}
