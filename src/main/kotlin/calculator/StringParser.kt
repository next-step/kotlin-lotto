package calculator

class StringParser {
    fun split(text: String): List<String> {
        if (text.isBlank()) return emptyList()

        val (content, customSeparator) = extractCustomSeparatorAndContent(text)
        return splitContent(content, customSeparator)
    }

    internal fun extractCustomSeparatorAndContent(text: String): Pair<String, String> {
        val matchResult = CUSTOM_SEPARATOR_PATTERN.find(text)
        return if (matchResult != null) {
            val customSeparator = matchResult.groupValues[1]
            val content = text.replaceFirst(CUSTOM_SEPARATOR_PATTERN, "")
            content to customSeparator
        } else {
            text to DEFAULT_SEPARATOR_REGEX
        }
    }

    fun splitContent(
        content: String,
        customSeparator: String = DEFAULT_SEPARATOR_REGEX,
    ): List<String> {
        val separatorRegex = customSeparator.toRegex()
        return content.split(separatorRegex).filter { it.isNotBlank() }
    }

    companion object {
        private val CUSTOM_SEPARATOR_PATTERN = Regex("//(.)\n")
        private const val DEFAULT_SEPARATOR_REGEX = "[,:]"
    }
}
