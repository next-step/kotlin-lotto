package calculator

import calculator.utils.CustomDelimiterExtractor
import calculator.utils.TextSplitter

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) return 0
        val (customDelimiter, extractResult) = CustomDelimiterExtractor.extract(text)
        val delimiters = Delimiters(customDelimiter)
        val tokens = TextSplitter.splitText(extractResult, delimiters.getDelimiters())
        return PositiveNumbers(tokens).sum()
    }
}
