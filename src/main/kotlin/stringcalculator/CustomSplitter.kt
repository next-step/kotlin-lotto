package stringcalculator

object CustomSplitter : Splitter {

    private const val CUSTOM_SPLITTER = "//(.)\n(.*)"
    private val CUSTOM_REGEX = Regex(CUSTOM_SPLITTER)

    override fun splitStrings(text: String): List<String> {
        val result = CUSTOM_REGEX.find(text)

        result?.let {
            val customDelimiter = it.groupValues[1]
            return it.groupValues[2].split(customDelimiter)
        }

        return emptyList()
    }
}
