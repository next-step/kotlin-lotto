package stringcalculator.service

object StringParser {
    val DEFAULT_DELIMITER = Regex("""[,:]""")
    val CUSTOM_DELIMITED_TEXT_REGEX = Regex("""^//(.+)\\n(.*)$""")

    fun convertToList(input: String): List<String> {
        return CUSTOM_DELIMITED_TEXT_REGEX.find(input)
            ?.destructured?.run { split(component1(), component2()) }
            ?: split(DEFAULT_DELIMITER, input)
    }

    private fun split(delimiter: Regex, delimitedBody: String): List<String> {
        return delimitedBody.split(delimiter)
    }

    private fun split(delimiter: String, delimitedBody: String): List<String> {
        return delimitedBody.split(delimiter)
    }
}
