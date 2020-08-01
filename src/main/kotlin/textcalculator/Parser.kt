package textcalculator

import java.util.regex.Pattern

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

    val regexCustomPrefix = "^(\\/\\/)(.)(\\n).*"

    fun split(text: String): List<String> {
        return text.split(regexDelimiters)
    }

    fun checkIfCustomPrefix(text: String) {
        Pattern.compile(regexCustomPrefix).matcher(text)
            .takeIf { it.matches() }
            ?.group(2)
            ?.let { custom ->
                _spliter.add(custom)
            }
    }

    companion object {
        private const val COMMA = ","
        private const val COLON = ":"
        private const val REGEX_OPEN = "["
        private const val REGEX_CLOSE = "]"
        private const val EMPTY = ""
    }
}
