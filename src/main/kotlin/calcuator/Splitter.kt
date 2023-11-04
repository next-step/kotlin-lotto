package calcuator

object Splitter {
    private val DEFAULT_DELIMITERS = arrayOf(",", ":")
    private val REGEX_FOR_CUSTOM_DELIMITER = """^//(.)\n(.*)$""".toRegex()

    fun split(input: String): List<String> = toNumbers(input)

    private fun toNumbers(input: String): List<String> {
        val (customDelimiter, restString) = extractCustomDelimiter(input)
        return splitByDelimiter(restString, customDelimiter)
    }

    private fun extractCustomDelimiter(input: String): Pair<String?, String> {
        val matchResult = REGEX_FOR_CUSTOM_DELIMITER.find(input) ?: return null to input
        val (customDelimiter, restString) = matchResult.destructured
        return customDelimiter to restString
    }

    private fun splitByDelimiter(input: String, customDelimiter: String?): List<String> {
        val delimiters: Array<String> = DEFAULT_DELIMITERS.let {
            if (customDelimiter != null) arrayOf(customDelimiter) + it
            else it
        }
        return input.split(*delimiters)
    }
}
