package calculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return 0
        }

        val extractResult = extractCustomDelimiter(text)
        val tokens = splitter(extractResult, delimiters)
        val convertedTokens = convertTokensToNumber(tokens)
        checkNegativeNumbers(convertedTokens)
        return convertTokensToNumber(tokens).sum()
    }

    fun extractCustomDelimiter(text: String): String {
        val result = Regex("//(.)\n(.*)").find(text)
        var extractResult: String = text
        result?.let {
            delimiters.add(it.groupValues[1])
            extractResult = it.groupValues[2]
        }
        return extractResult
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
