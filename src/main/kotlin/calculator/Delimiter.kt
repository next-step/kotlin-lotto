package calculator

object Delimiter {
    private const val CUSTOM_DELIMITER_START_FLAG = "//"
    private const val CUSTOM_DELIMITER_END_FLAG = "\n"
    private const val MINUS_OPERATOR = "-"
    private val DEFAULT_DELIMITERS = listOf(",",":")

    fun getDelimitersOfText(text: String): List<String> {
        val delimiters = mutableListOf<String>().apply{ addAll(DEFAULT_DELIMITERS) }
        if (existCustomizedDelimiter(text)) {
            delimiters.addAll(getCustomizedDelimiter(text))
        }
        return delimiters
    }

    fun existCustomizedDelimiter(text: String): Boolean {
        return getIndexOfStartFlag(text) == 0 && getIndexOfEndFlag(text) != -1
    }

    fun getIndexOfAfterFlag(text: String): Int {
        return getIndexOfEndFlag(text) + CUSTOM_DELIMITER_END_FLAG.length
    }

    private fun getIndexOfStartFlag(text: String): Int {
        return text.indexOf(CUSTOM_DELIMITER_START_FLAG)
    }

    private fun getIndexOfEndFlag(text: String): Int {
        return text.indexOf(CUSTOM_DELIMITER_END_FLAG)
    }

    private fun getCustomizedDelimiter(text: String): List<String> {
        val startIndex = text.indexOf(CUSTOM_DELIMITER_START_FLAG) + CUSTOM_DELIMITER_START_FLAG.length
        val endIndex = text.indexOf(CUSTOM_DELIMITER_END_FLAG, startIndex)
        return text.substring(startIndex, endIndex)
            .map{ it.toString() }
            .onEach { char -> require(char != MINUS_OPERATOR) }
    }

}