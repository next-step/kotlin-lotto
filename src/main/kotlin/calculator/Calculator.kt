package calculator

class Calculator {
    fun calculate(text: String?): Int {
        if (text.isNullOrEmpty()) return 0
        if (text.toIntOrNull() != null) return text.toInt()

        val tokens = parseWithDelimeter(text).map { Token(it) }

        return ParsedTokens(tokens).result
    }

    private fun parseWithDelimeter(text: String): List<String> {
        val result = Regex("//(.)\n(.*)").find(text)

        return result?.let {
            val customDelimiter = it.groupValues[1]
            it.groupValues[2].split(customDelimiter)
        } ?: run {
            text.split(",|:".toRegex())
        }
    }
}
