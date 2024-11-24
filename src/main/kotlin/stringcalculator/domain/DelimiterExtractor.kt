package stringcalculator.domain

class DelimiterExtractor {
    companion object {
        private const val CUSTOM_DELIMITER_PREFIX = "//"
        private const val CUSTOM_DELIMITER_SEPARATOR = "\n"
        private const val DEFAULT_DELIMITERS = ",:"
    }

    fun extract(input: String): Pair<Regex, String> {
        return if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            val regex = Regex("$CUSTOM_DELIMITER_PREFIX(.*)$CUSTOM_DELIMITER_SEPARATOR(.*)")
            val matchResult =
                regex.find(input) ?: throw RuntimeException("Invalid input format: $input")
            val (customDelimiter, numbersPart) = matchResult.destructured
            Regex("[${Regex.escape(customDelimiter)}${DEFAULT_DELIMITERS}]") to numbersPart
        } else {
            Regex("[$DEFAULT_DELIMITERS]") to input
        }
    }
}
