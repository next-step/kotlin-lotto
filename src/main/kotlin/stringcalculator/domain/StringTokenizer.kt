package stringcalculator.domain

class StringTokenizer {

    companion object {
        private const val COMMA_DELIMITER = ","
        private const val COLON_DELIMITER = ":"
        private val DEFAULT_DELIMITERS = arrayOf(COMMA_DELIMITER, COLON_DELIMITER)
        private const val DEFAULT_SUFFIX_OF_CUSTOM_DELIMITER = "//"
        private const val DEFAULT_PREFIX_OF_CUSTOM_DELIMITER = "\n"

        fun tokenize(numbersString: String): Tokens {
            val customDelimiter = Regex("$DEFAULT_SUFFIX_OF_CUSTOM_DELIMITER(.)$DEFAULT_PREFIX_OF_CUSTOM_DELIMITER(.*)").find(numbersString)
            customDelimiter?.let {
                val customDelimiter = it.groupValues[1]
                val matchedNumbersString = it.groupValues[2]

                return Tokens(matchedNumbersString.split(customDelimiter))
            }

            return Tokens(numbersString.split(*DEFAULT_DELIMITERS))
        }
    }
}
