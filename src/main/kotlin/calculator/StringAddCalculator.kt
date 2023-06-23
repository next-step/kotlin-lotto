package calculator

import calculator.utils.CustomDelimiterExtractor

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) return 0
        val (customDelimiter, extractResult) = CustomDelimiterExtractor.extract(text)
        val delimiters = Delimiters(customDelimiter)
        val tokens = delimiters.splitText(extractResult)
        return PositiveNumbers(tokens).sum()
    }
}
