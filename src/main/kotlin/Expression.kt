class Expression {

    private var delemiterRegex: String

    init {
        delemiterRegex = DEFAULT_DELEMITER_REGEX
    }

    fun getTokens(text: String): List<Int> {
        val customizedInput: String? = toCustomSplitter(text)

        return customizedInput?.let {
            if (it?.trim().isNullOrEmpty()) return listOf(0)
            else {
                if (it.split(delemiterRegex.toRegex())?.any { it.toInt() < 0 }) throw RuntimeException()
                it.split(delemiterRegex.toRegex()).map { it.toInt() }
            }
        }!!
    }

    private fun toCustomSplitter(text: String): String? {
        val result = Regex(NEWLINE_REGEX).find(text)
        return result?.let {
            val customDelimiter = it.groupValues[1]
            delemiterRegex = customDelimiter

            it.groupValues[2]
        } ?: text
    }

    companion object {
        private val NEWLINE_REGEX = """//(.)\\n(.*)"""
        private val DEFAULT_DELEMITER_REGEX = ",|:"
    }
}
