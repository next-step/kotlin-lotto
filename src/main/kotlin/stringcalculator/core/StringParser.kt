package stringcalculator.core

object StringParser {
    private const val REGEX_FIND_CUSTOM_DELIMITER = "(?<=//)(.*?)(?=\n)"

    fun parse(str: String?): List<Number> {
        if (str.isNullOrBlank()) {
            return listOf(Number("0"))
        }

        val strings = getSplitter(str).split()

        return strings.map(::Number)
    }

    private fun getSplitter(str: String): Splitter {
        if (str.length < 4) {
            return Splitter(str)
        }
        val delimiterStr = getCustomDelimiter(str)
        if (delimiterStr.isNullOrBlank()) {
            return Splitter(str)
        }
        return Splitter(str.substring(4), delimiterStr)
    }

    private fun getCustomDelimiter(str: String): String? {
        val matchResult = Regex(REGEX_FIND_CUSTOM_DELIMITER).find(str)
        return matchResult?.value
    }
}
