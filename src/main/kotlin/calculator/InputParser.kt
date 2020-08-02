package calculator

import java.util.regex.Pattern

class InputParser(private val text: String) {
    var numbersParsed: List<Int>
        private set

    init {
        numbersParsed =
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
        // tokens.forEach { print(it+" ${tokens} ")}
        checkIllegalInput(tokens)

        return tokens.map { it.toInt() }
    }

    private fun checkIllegalInput(tokens: List<String>) {
        if (tokens.any {
                it.toIntOrNull() == null ||
                it.toInt() < 0
            }) {
            throw RuntimeException(NOT_ALLOW_LETTER_OR_NEGATIVE)
        }
    }

    companion object {
        private const val DELIMITER_COMMA = ","
        private const val DELIMITER_COLON = ":"
        private const val CUSTOM_PATTERN = "//(.)\\\\n(.*)"
        private const val NOT_ALLOW_LETTER_OR_NEGATIVE = "숫자 이외의 값 또는 음수 입력 불가"

        private val customPatten: Pattern = Pattern.compile(CUSTOM_PATTERN)
    }
}
