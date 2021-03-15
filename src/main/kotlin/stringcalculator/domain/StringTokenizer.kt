package stringcalculator.domain

object StringTokenizer {

    private const val COMMA_DELIMITER = ","
    private const val COLON_DELIMITER = ":"
    private val DEFAULT_DELIMITERS = arrayOf(COMMA_DELIMITER, COLON_DELIMITER)
    private const val DEFAULT_SUFFIX_OF_CUSTOM_DELIMITER = "//"
    private const val DEFAULT_PREFIX_OF_CUSTOM_DELIMITER = "\n"
    private const val DEFAULT_CUSTOM_DELIMITER_REGEX = "$DEFAULT_SUFFIX_OF_CUSTOM_DELIMITER(.)$DEFAULT_PREFIX_OF_CUSTOM_DELIMITER(.*)"

    fun tokenize(numbersString: String): Tokens {
        val customDelimiter = Regex(DEFAULT_CUSTOM_DELIMITER_REGEX).find(numbersString)
        customDelimiter?.let {
            val (customDelimiter, matchedNumbersString) = it.destructured

            return Tokens.from(matchedNumbersString.split(customDelimiter))
        }

        return Tokens.from(numbersString.split(*DEFAULT_DELIMITERS))
    }
}
