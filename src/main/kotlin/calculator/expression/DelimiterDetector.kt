package calculator.expression

class DelimiterDetector(input: String?) {

    val delimiter: String
    val stringInput: String

    init {
        val customDelimiter = CUSTOM_DELIMITER_REGEX.find(input ?: "")
        delimiter = customDelimiter?.groupValues?.get(1)?.let { Regex.escape(it) } ?: DEFAULT_DELIMITER
        stringInput = customDelimiter?.groupValues?.get(2) ?: (input ?: "")
    }

    companion object {
        val CUSTOM_DELIMITER_REGEX = Regex("//(.)\n(.*)")
        const val DEFAULT_DELIMITER = "[,:]"
    }
}
