package textcalculator

class Parser {
    private val _spliter = mutableListOf(COMMA, COLON)
    val spliter: List<String> get() = _spliter
    private val regexDelimiters
        get() = Regex(
            spliter.joinToString(
                prefix = REGEX_OPEN,
                postfix = REGEX_CLOSE,
                separator = EMPTY
            ) { it }
        )

    fun String.split(): List<String> {
        return split(regexDelimiters)
    }

    fun addCustomDelimiter(delimiter: String) {
        if (delimiter.isNotBlank()) {
            _spliter.add(delimiter)
        }
    }

    fun List<String>.toInts(): List<Int> {
        return map {
            require(it.matches(Regex(REGEX_STRING_ONLY_NUMBERS)))
            it.toInt()
        }
    }

    fun parse(text: String): List<Int> {
        return divideByRegex(text).let {
            addCustomDelimiter(it.getCustomDelimiter())
            it.getMainText()
                .split()
                .toInts()
        }
    }

    fun divideByRegex(text: String): MatchResult {
        return Regex(REGEX_STRING_BY_GROUP).find(text) ?: throw RuntimeException(ERROR_WRONG_FORMAT)
    }

    fun MatchResult.getCustomDelimiter(): String {
        return groupValues[GROUP_CUSTOM_SPLITER]
    }

    fun MatchResult.getMainText(): String {
        return groupValues[GROUP_MAIN_TEXT]
    }

    companion object {
        private const val COMMA = ","
        private const val COLON = ":"
        private const val REGEX_OPEN = "["
        private const val REGEX_CLOSE = "]"
        private const val EMPTY = ""
        private const val REGEX_STRING_BY_GROUP = "^((\\/\\/)(.)(\\\\n))*(.*)"
        private const val REGEX_STRING_ONLY_NUMBERS = "[0-9]*"
        private const val GROUP_CUSTOM_SPLITER = 3
        private const val GROUP_MAIN_TEXT = 5
        private const val ERROR_WRONG_FORMAT = "형식이 잘못 되었습니다."
    }
}
