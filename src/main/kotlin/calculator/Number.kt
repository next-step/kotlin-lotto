package calculator

import java.util.regex.Pattern

class Number(private val text: String) {
    var numbers: List<Int>
        private set

    init {
        numbers =
            if (hasCustomDelimiter(text)) {
                customNumbers()
            } else {
                defaultNumbers()
            }
    }

    private fun hasCustomDelimiter(text: String): Boolean {
        return customPatten.matcher(text).find()
    }

    private fun customNumbers(): List<Int> {
        val result = CUSTOM_PATTERN.toRegex().find(text) ?: return emptyList()

        val customDelimiter = result.groupValues[1]
        val tokens = result.groupValues[2].split(customDelimiter)
        checkIllegalInput(tokens)

        return tokens.map { it.toInt() }
    }

    private fun defaultNumbers(): List<Int> {
        val tokens = text.split(DELIMITER_COMMA, DELIMITER_COLON)
        checkIllegalInput(tokens)

        return tokens.map { it.toInt() }
    }

    private fun checkIllegalInput(tokens: List<String>) {
        tokens.forEach {
            if (excludeNumberPattern.matcher(it).find() ||
                0 > it.toInt()
            ) {
                throw RuntimeException(NOT_ALLOW_LETTER_OR_NEGATIVE)
            }
        }
    }

    companion object {
        const val DELIMITER_COMMA = ","
        const val DELIMITER_COLON = ":"
        const val CUSTOM_PATTERN = "//(.)\\\\n(.*)"
        const val EXCLUDE_NUMBER_PATTERN = "[^0-9]+"
        const val NOT_ALLOW_LETTER_OR_NEGATIVE = "숫자 이외의 값 또는 음수 입력 불가"

        private val customPatten: Pattern = Pattern.compile(CUSTOM_PATTERN)
        private val excludeNumberPattern: Pattern = Pattern.compile(EXCLUDE_NUMBER_PATTERN)
    }
}
