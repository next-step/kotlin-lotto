package calculator

import calculator.utils.CustomDelimiterExtractor
import calculator.utils.TextSplitter
import calculator.utils.TokenConverter

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) return 0
        var delimiters = Delimiters()
        val (customDelimiter, extractResult) = CustomDelimiterExtractor.extract(text)
        if (!customDelimiter.isNullOrEmpty()) delimiters = delimiters.plusCustomDelimiters(customDelimiter)
        val tokens = TextSplitter.splitText(extractResult, delimiters.getDelimiters())
        val convertedTokens = TokenConverter.convertToInt(tokens)
        return PositiveNumbers(convertedTokens).sum()
    }
}
