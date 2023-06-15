package calculator

class StringAddCalculator {
    private var delimiters = mutableListOf(",", ":")
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return 0
        }

        val extractResult = extractCustomDelimiter(text)
        val tokens = splitter(extractResult, delimiters)
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
        return tokens.mapNotNull { token ->
            val result = token.toIntOrNull()
            if (result != null && result >= 0) {
                result
            } else {
                throw RuntimeException("Invalid token: $token")
            }
        }
    }
}
