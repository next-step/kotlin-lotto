package textcalculator

class Parser {
    private val _spliter = arrayListOf(COMMA, COLON)
    val spliter: List<String> get() = _spliter
    val regexDelimiters = Regex(
        spliter.joinToString(
            prefix = REGEX_OPEN,
            postfix = REGEX_CLOSE,
            separator = EMPTY
        ) { it }
    )

    fun split(text: String): List<String> {
        return text.split(regexDelimiters)
    }

    companion object {
        private const val COMMA = ","
        private const val COLON = ":"
        private const val REGEX_OPEN = "["
        private const val REGEX_CLOSE = "]"
        private const val EMPTY = ""
    }
}
