package calculator

class StringParser {
    fun split(text: String): List<String> {
        if (text.isBlank()) return emptyList()
        val customSeparator = extractCustomSeparator(text)
        val content = removeCustomSeparatorHeader(text, customSeparator)

        return splitContent(content, customSeparator)
    }

    internal fun extractCustomSeparator(text: String): String? {
        val matchResult = CUSTOM_SEPARATOR_PATTERN.find(text)
        return matchResult?.groupValues?.get(1)
    }

    internal fun removeCustomSeparatorHeader(
        text: String,
        customSeparator: String?,
    ): String {
        return customSeparator?.let { text.replaceFirst(CUSTOM_SEPARATOR_PATTERN, "") } ?: text
    }

    fun splitContent(
        content: String,
        customSeparator: String?,
    ): List<String> {
        val separatorRegex = customSeparator?.toRegex() ?: DEFAULT_SEPARATOR_REGEX.toRegex()
        return content.split(separatorRegex).filter { it.isNotBlank() }
    }

    companion object {
        private val CUSTOM_SEPARATOR_PATTERN = Regex("//(.)\n")
        private const val DEFAULT_SEPARATOR_REGEX = "[,:]"
    }
}
