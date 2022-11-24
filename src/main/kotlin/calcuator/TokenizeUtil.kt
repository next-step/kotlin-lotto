package calcuator

object TokenizeUtil {
    private val CUSTOM_DELIMITER = Regex("//(.)\n(.*)")
    private val DEFAULT_DELIMITER = Regex("[,:]")

    fun tokenizes(text: String): List<String> {
        val matcher = CUSTOM_DELIMITER.find(text)

        if (matcher != null) {
            val (customDelimiter: String, matchedText: String) = matcher.destructured

            return matchedText.split(customDelimiter)
        }

        return text.split(DEFAULT_DELIMITER)
    }
}
