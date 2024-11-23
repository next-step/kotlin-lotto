package calculator

object Parser {
    private const val FIND_CUSTOM_DELIMITER_PATTERN = "(?<=//)(.*?)(?=\\n)" // "//" 와 "\n" 사이의 구분자 1개 추출 표현식
    private const val CUSTOM_DELIMITER_PREFIX = "//"
    private const val CONTENT_DELIMITER = "\n"
    private val CUSTOM_DELIMITER_REGEX = Regex(FIND_CUSTOM_DELIMITER_PATTERN)
    private val DEFAULT_DELIMITERS = listOf(",", ":")

    fun parseToNumbers(text: String): List<Int> {
        val delimiters = extractDelimiters(text)
        val addTargetContent = extractAddTargetContent(text)
        return addTargetContent.split(*delimiters.toTypedArray())
            .map { it.toIntOrNull() ?: throw IllegalArgumentException("Invalid number format: $it") }
    }

    private fun extractDelimiters(text: String): List<String> {
        val customDelimiter = CUSTOM_DELIMITER_REGEX.find(text)?.value
        return if (customDelimiter != null) {
            DEFAULT_DELIMITERS + customDelimiter
        } else {
            DEFAULT_DELIMITERS
        }
    }

    private fun extractAddTargetContent(text: String): String {
        return if (text.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            text.substringAfter(CONTENT_DELIMITER)
        } else {
            text
        }
    }
}
