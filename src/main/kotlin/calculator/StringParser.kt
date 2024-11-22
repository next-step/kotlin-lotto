package calculator

class StringParser {
    fun split(text: String): List<String> {
        if (text.isBlank()) return emptyList()

        val (content, customSeparator) = extractCustomSeparatorAndContent(text)
        return splitContent(content, customSeparator)
    }

    internal fun extractCustomSeparatorAndContent(text: String): Pair<String, String> {
        val normalizeInput = normalizeInput(text)
        val matchResult = CUSTOM_SEPARATOR_PATTERN.find(normalizeInput)

        return if (matchResult != null) {
            val customSeparator = matchResult.groupValues[DELIMITER_INDEX]
            val content = matchResult.groupValues[VALUES_INDEX]
            content to customSeparator
        } else {
            text to DEFAULT_SEPARATOR_REGEX
        }
    }

    fun splitContent(
        content: String,
        customSeparator: String = DEFAULT_SEPARATOR_REGEX,
    ): List<String> {
        require(content.isNotBlank()) { "입력값이 비어있거나 공백이 포함되어 있습니다." }
        require(!content.contains("\\s".toRegex())) { "입력값이 비어있거나 공백이 포함되어 있습니다." }

        val separatorRegex = customSeparator.toRegex()
        return content.split(separatorRegex).filter { it.isNotBlank() }
    }

    private fun normalizeInput(input: String): String {
        return input.replace("\\n", "\n")
    }

    companion object {
        private val CUSTOM_SEPARATOR_PATTERN = Regex("//(.)\\n(.*)")
        private const val DEFAULT_SEPARATOR_REGEX = "[,:]"
        private const val DELIMITER_INDEX = 1
        private const val VALUES_INDEX = 2
    }
}
