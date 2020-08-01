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

    val regexCustomPrefix = REGEX_STRING_CUSTOM_PREFIX

    fun split(text: String): List<String> {
        return text.split(regexDelimiters)
    }

    fun checkIfCustomPrefix(text: String): String {
        val matches = Pattern.compile(regexCustomPrefix).matcher(text)
            .takeIf { it.matches() }

        matches?.group(2)
            ?.also { custom ->
                _spliter.add(custom)
            }

        return matches?.group(4) ?: text
    }

    fun List<String>.toInts(): List<Int> {
        return map {
            require(it.matches(Regex(REGEX_STRING_ONLY_NUMBERS)))
            it.toInt()
        }
    }

    companion object {
        private const val COMMA = ","
        private const val COLON = ":"
        private const val REGEX_OPEN = "["
        private const val REGEX_CLOSE = "]"
        private const val EMPTY = ""
        private const val REGEX_STRING_CUSTOM_PREFIX = "^(\\/\\/)(.)(\\n)(.*)"
        private const val REGEX_STRING_ONLY_NUMBERS = "[0-9]*"
    }
}
