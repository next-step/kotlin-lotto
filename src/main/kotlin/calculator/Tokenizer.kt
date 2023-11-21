package calculator

object Tokenizer {

    private const val DEFAULT_DELIMITERS: String = ",|:"
    private const val CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)"

    fun tokenize(input: String): List<String> {
        val customDelimiterMatchResult = Regex(CUSTOM_DELIMITER_PATTERN).find(input)

        return if (customDelimiterMatchResult != null) {
            val (customDelimiter, numbers) = customDelimiterMatchResult.destructured
            numbers.split(customDelimiter)
        } else {
            input.split(DEFAULT_DELIMITERS.toRegex())
        }
    }
}
