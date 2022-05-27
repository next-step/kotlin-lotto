package stringcalculator

object DefaultSplitter : Splitter {

    private const val DEFAULT_SPLITTER = "[,:]"
    private val DEFAULT_REGEX = DEFAULT_SPLITTER.toRegex()

    override fun splitStrings(text: String): List<String> {
        return text.split(DEFAULT_REGEX)
    }
}
