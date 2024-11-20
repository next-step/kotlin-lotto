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
            return normalizedText.split(DEFAULT_DELIMITER).map(String::toInt)
        }

        private fun extractCustomDelimiter(text: String): String? {
            if (!text.startsWith(CUSTOM_DELIMITER_PREFIX)) {
                return null
            }

            val customDelimiter: String =
                text
                    .substringAfter(CUSTOM_DELIMITER_PREFIX)
                    .substringBefore(CUSTOM_DELIMITER_SUFFIX)

            if (customDelimiter.isEmpty()) {
                throw IllegalArgumentException("올바르지 않은 커스텀 구분자 형식입니다")
            }

            return customDelimiter
        }

        private fun normalizeText(
            text: String,
            customDelimiter: String?,
        ): String =
            when (customDelimiter) {
                null -> text.replace(DEFAULT_DELIMITER_2, DEFAULT_DELIMITER)
                else ->
                    text
                        .replace(
                            CUSTOM_DELIMITER_PREFIX + customDelimiter + CUSTOM_DELIMITER_SUFFIX,
                            "",
                        )
                        .replace(customDelimiter, DEFAULT_DELIMITER)
                        .replace(DEFAULT_DELIMITER_2, DEFAULT_DELIMITER)
            }
    }
}
