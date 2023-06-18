package calculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return 0
        }

        val delimiters = Delimiters.DEFAULT
        val (customDelimiter, extractResult) = CustomDelimiterExtractor.extract(text)
        if (!customDelimiter.isNullOrEmpty()) {
            delimiters.addCustomDelimiters(customDelimiter)
        }
        val tokens = TextSplitter.splitText(extractResult, delimiters.getDelimiters())
        val convertedTokens = convertTokensToNumber(tokens)
        checkNegativeNumbers(convertedTokens)
        return convertTokensToNumber(tokens).sum()
    }

    fun convertTokensToNumber(tokens: List<String>): List<Int> {
        return try {
            tokens.map { it.toInt() }
        } catch (e: NumberFormatException) {
            throw RuntimeException("Invalid token: $tokens")
        }
    }

    fun checkNegativeNumbers(numbers: List<Int>) {
        if (numbers.any { it < 0 }) {
            throw RuntimeException("Negative numbers are not allowed")
        }
    }
}
