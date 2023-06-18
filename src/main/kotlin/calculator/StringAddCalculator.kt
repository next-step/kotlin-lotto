package calculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return 0
        }

        val delimiters = Delimiters.DEFAULT
        val (customDelimiter, extractResult) = extractCustomDelimiter(text)
        if (!customDelimiter.isNullOrEmpty()) {
            delimiters.addCustomDelimiters(customDelimiter)
        }
        val tokens = splitter(extractResult, delimiters.getDelimiters())
        val convertedTokens = convertTokensToNumber(tokens)
        checkNegativeNumbers(convertedTokens)
        return convertTokensToNumber(tokens).sum()
    }

    fun extractCustomDelimiter(text: String): Pair<String, String> {
        val regex = Regex("//(.)\n(.*)")
        val matchResult = regex.find(text)
        val extractedDelimiter = matchResult?.groupValues?.getOrNull(1) ?: ""
        val extractedText = matchResult?.groupValues?.getOrNull(2) ?: text
        return extractedDelimiter to extractedText
    }

    fun splitter(text: String, delimiters: List<String>): List<String> {
        val regexPattern = delimiters.joinToString(separator = "|")
        return text.split(regexPattern.toRegex())
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

    companion object {
        private var delimiters = mutableListOf(",", ":")
    }
}
