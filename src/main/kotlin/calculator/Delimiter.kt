package calculator

class Delimiter {

    fun getDelimitersOfText(text: String): List<String> {
        val delimiters = mutableListOf<String>().apply{ addAll(DEFAULT_DELIMITERS) }
        val customDelimiter = CUSTOM_DELIMITER_FLAG_REGEX.find(text)?.groupValues?.get(1)?.toList()
        customDelimiter?.let {
            require(it.all { char -> char.toString() != MINUS_OPERATOR })
            delimiters.addAll(it.map { char -> char.toString() })
        }
        return delimiters
    }

    companion object {
        private const val MINUS_OPERATOR = "-"
        private val DEFAULT_DELIMITERS = listOf(",",":")
        val CUSTOM_DELIMITER_FLAG_REGEX = "//(.)\n(.*)".toRegex()
    }
}