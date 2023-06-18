package calculator

object PositiveNumber {
    fun checkPositiveNumbers(numbers: List<Int>) {
        if (numbers.any { it < 0 }) {
            throw RuntimeException("Negative numbers are not allowed")
        }
    }
}
class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) return 0
        val delimiters = Delimiters.DEFAULT
        val (customDelimiter, extractResult) = CustomDelimiterExtractor.extract(text)
        if (!customDelimiter.isNullOrEmpty()) delimiters.addCustomDelimiters(customDelimiter)
        val tokens = TextSplitter.splitText(extractResult, delimiters.getDelimiters())
        val convertedTokens = TokenConverter.convertToInt(tokens)
        PositiveNumber.checkPositiveNumbers(convertedTokens)
        return convertedTokens.sum()
    }
}
