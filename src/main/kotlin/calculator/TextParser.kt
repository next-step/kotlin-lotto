package calculator

class TextParser {
    companion object {
        private const val DEFAULT_DELIMITER: String = ","
        private const val DEFAULT_DELIMITER_2: String = ":"

        private const val CUSTOM_DELIMITER_PREFIX: String = "//"
        private const val CUSTOM_DELIMITER_SUFFIX: String = "\n"

        fun parse(text: String?): List<Int> {
            if (text.isNullOrBlank()) {
                return listOf()
            }

            val customDelimiter: String? = extractCustomDelimiter(text)
            val normalizedText = normalizeText(text, customDelimiter)
            return parseToNumbers(normalizedText)
        }

        private fun parseToNumbers(normalizedText: String): List<Int> = normalizedText.split(DEFAULT_DELIMITER).map(String::toInt)

        private fun extractCustomDelimiter(text: String): String? {
            if (!containsCustomDelimiter(text)) {
                return null
            }

            return getCustomDelimiter(text)
        }

        private fun containsCustomDelimiter(text: String) = text.startsWith(CUSTOM_DELIMITER_PREFIX)

        private fun getCustomDelimiter(text: String) =
            text
                .substringAfter(CUSTOM_DELIMITER_PREFIX)
                .substringBefore(CUSTOM_DELIMITER_SUFFIX)

        private fun normalizeText(
            text: String,
            customDelimiter: String?,
        ): String {
            val textWithoutCustomDelimiter: String =
                customDelimiter?.run {
                    replaceToDefaultDelimiter(removeCustomDelimiterFormat(text, this), this)
                } ?: text
            return replaceToDefaultDelimiter(textWithoutCustomDelimiter)
        }

        private fun removeCustomDelimiterFormat(
            text: String,
            customDelimiter: String,
        ): String =
            text
                .replace(CUSTOM_DELIMITER_PREFIX + customDelimiter + CUSTOM_DELIMITER_SUFFIX, "")

        private fun replaceToDefaultDelimiter(
            text: String,
            delimiter: String = DEFAULT_DELIMITER_2,
        ) = text.replace(delimiter, DEFAULT_DELIMITER)
    }
}
