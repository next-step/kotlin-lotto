package calculator.delimiter

object DefaultDelimiterSplitter : DelimiterSplitter {
    private val DEFAULT_DELIMITER = Regex("[,:]")

    override fun isSupport(text: String): Boolean {
        return true
    }

    override fun split(text: String): List<String> {
        return text.split(DEFAULT_DELIMITER)
    }
}
