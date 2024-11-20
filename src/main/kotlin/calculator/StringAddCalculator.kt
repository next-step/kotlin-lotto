package calculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        if (text.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            val customDelimiterSuffixIndex = text.indexOf(CUSTOM_DELIMITER_SUFFIX)
            if (customDelimiterSuffixIndex > CUSTOM_DELIMITER_PREFIX.length) {
                val customDelimiter =
                    text.substring(CUSTOM_DELIMITER_PREFIX.length, customDelimiterSuffixIndex)

                val operands =
                    text
                        .replace(
                            CUSTOM_DELIMITER_PREFIX + customDelimiter + CUSTOM_DELIMITER_SUFFIX,
                            "",
                        )
                        .replace(customDelimiter, DEFAULT_DELIMITER)
                        .replace(DEFAULT_DELIMITER_2, DEFAULT_DELIMITER)
                        .split(DEFAULT_DELIMITER)
                        .map { it.toInt() }

                return Operands(operands).sum()
            }
        }

        val operands =
            text
                .replace(DEFAULT_DELIMITER_2, DEFAULT_DELIMITER)
                .split(DEFAULT_DELIMITER)
                .map { it.toInt() }

        return Operands(operands).sum()
    }

    companion object {
        private const val DEFAULT_DELIMITER: String = ","
        private const val DEFAULT_DELIMITER_2: String = ":"
        private const val CUSTOM_DELIMITER_PREFIX: String = "//"
        private const val CUSTOM_DELIMITER_SUFFIX: String = "\n"
    }
}
