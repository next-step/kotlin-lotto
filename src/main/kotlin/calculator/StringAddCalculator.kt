package calculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty() || text.isBlank()) {
            return 0
        }
        val delimiter = findDelimiter(text)
        val numbers = extractNumberString(delimiter, text)
        val parsedNumbers = parseNumbers(numbers)

        return parsedNumbers.sum()
    }

    private fun findDelimiter(text: String): String {
        if (!text.startsWith("//")) return DEFAULT_REGEX
        return text.substringAfter("//").substringBefore("\n")
    }

    private fun extractNumberString(
        delimiter: String,
        text: String,
    ): List<String> {
        if (delimiter == DEFAULT_REGEX) {
            return text.split(Regex(delimiter))
        }

        return text.substringAfter("\n").split(Regex(delimiter))
    }

    private fun parseNumbers(splitNumbers: List<String>): List<Int> {
        return splitNumbers.map {
            it.toIntOrNull() ?: throw RuntimeException("Invalid input: $it")
        }.apply {
            if (any { it < 0 }) throw RuntimeException("Negative numbers are not allowed: $this")
        }
    }

    companion object {
        const val DEFAULT_REGEX = "[,:\n]"
    }
}
