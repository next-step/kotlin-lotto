package calculator.domain

class StringAddTokenizer(private val text: String) {

    fun getTokens(): List<String> {
        val result = FIND_CUSTOM_DELIMITER_REGEX.find(text)
        if (result != null) {
            val customDelimiter = result.groupValues[1]
            val target = result.groupValues[2]
            return target.split(customDelimiter)
        }
        return text.split(DEFAULT_DELIMITER_REGEX)
    }

    companion object {
        private val DEFAULT_DELIMITER_REGEX: Regex = "[,|:]".toRegex()
        private val FIND_CUSTOM_DELIMITER_REGEX: Regex = "//(.)\n(.*)".toRegex()
    }
}
