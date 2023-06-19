package stringcalculator

class StringParser {
    companion object {
        private const val CUSTOM_DELIMITER_INDEX = 1
        private const val WITHOUT_CUSTOM_DELIMITER_EXPRESSION_INDEX = 2
        fun deleteCustomDelimiters(text: String, delimiters: Delimiters): String {
            val matchResult = Regex(Delimiters.CUSTOM_DELIMITER_FIND_REGEX).find(text)
            matchResult?.let {
                delimiters.addDelimiter(it.groupValues[CUSTOM_DELIMITER_INDEX])
                return it.groupValues[WITHOUT_CUSTOM_DELIMITER_EXPRESSION_INDEX]
            }
            return text
        }
    }
}
