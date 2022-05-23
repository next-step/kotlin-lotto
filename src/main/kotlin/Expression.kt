class Expression {

    private var delemiterRegex: Regex

    init {
        delemiterRegex = DEFAULT_DELEMITER_REGEX
    }

    fun getTokens(text: String): List<Int> {
        val customizedInput: String? = toCustomSplitter(text)

        if (customizedInput == null || customizedInput.trim().isNullOrEmpty()) return listOf(0)

        if (customizedInput.split(delemiterRegex)?.any { it.toInt() < 0 }) throw RuntimeException()
        return customizedInput.split(delemiterRegex).map { it.toInt() }
    }

    private fun toCustomSplitter(text: String): String? {
        val result = NEWLINE_REGEX.find(text)
        return result?.let {
            val customDelimiter = it.groupValues[1]
            delemiterRegex = Regex(customDelimiter)

            it.groupValues[2]
        } ?: text
    }

    companion object {
        private val NEWLINE_REGEX = Regex("""//(.)\\n(.*)""")
        private val DEFAULT_DELEMITER_REGEX = Regex(",|:")
    }
}
