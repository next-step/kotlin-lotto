class Expression {
    var operators = listOf<String>()
    var digits = listOf<String>()

    fun getTokens(text: String): List<Int>? {
        val result = Regex(NEWLINE_REGEX).find(text)
        val inputString = result?.let {
            val customDelimiter = it.groupValues[1]
            DELEMITER_REGEX = customDelimiter

            it.groupValues[2]
        }

        val tokens = inputString?.let {
            if (it?.trim().isNullOrEmpty()) {
                return listOf(0)
            } else {
                it.split(DELEMITER_REGEX.toRegex()).map { it.toInt() }
            }
        }

        require(tokens?.all { it > 0 } ?: false)

        return tokens
    }

    companion object {
        private val NEWLINE_REGEX = """//(.)\\n(.*)"""
        private var DELEMITER_REGEX = ",|:"
    }
}