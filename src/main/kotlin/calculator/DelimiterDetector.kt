package calculator

class DelimiterDetector(input: String?) {

    val delimiter: String
    val stringInput: String

    init {
        val customDelimiter = Regex(CUSTOM_DELIMITER).find(input ?: "")
        delimiter = customDelimiter?.groupValues?.get(1)?.let { Regex.escape(it) } ?: DEFAULT_DELIMITER
        stringInput = customDelimiter?.groupValues?.get(2) ?: (input ?: "")
    }

    companion object {
        const val CUSTOM_DELIMITER = "//(.)\n(.*)"
        const val DEFAULT_DELIMITER = "[,:]"
    }
}
