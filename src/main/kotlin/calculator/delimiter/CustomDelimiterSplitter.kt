package calculator.delimiter

object CustomDelimiterSplitter : DelimiterSplitter {
    private val CUSTOM_DELIMITER = Regex("//(.)\n(.*)")
    private const val CUSTOM_DELIMITER_PREFIX = "//"

    override fun isSupport(text: String): Boolean {
        return text.startsWith(CUSTOM_DELIMITER_PREFIX)
    }

    override fun split(text: String): List<String> {
        val matchResult = CUSTOM_DELIMITER.find(text) ?: throw IllegalArgumentException("Invalid input")
        val (delimiter, numbers) = matchResult.destructured
        return numbers.split(delimiter)
    }
}
