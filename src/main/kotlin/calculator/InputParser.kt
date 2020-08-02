package calculator

import java.util.regex.Pattern

private const val COMMA = ","
private const val COLON = ":"
private const val CUSTOM_PATTERN = "//(.)\\\\n(.*)"
private const val NOT_ALLOW_LETTER_OR_NEGATIVE = "숫자 이외의 값 또는 음수 입력 불가"
private val customRegex : Regex = CUSTOM_PATTERN.toRegex()

object InputParser {

    fun parse(baseText: String): List<Int> {
        val result = customRegex.find(baseText)
        var text = baseText
        var customDelimiter = COMMA

        result?.let {
            customDelimiter = result.groupValues[1]
            text = result.groupValues[2]
        }

        return splitFrom(text, customDelimiter)
    }

    private fun splitFrom(text: String, custom: String): List<Int> {
        val tokens = text.split(COMMA, COLON, custom)
        checkIllegalToken(tokens)

        return tokens.map { it.toInt() }
    }

    private fun checkIllegalToken(tokens: List<String>) {
        if (tokens.any {
            it.toIntOrNull() == null ||
                it.toInt() < 0
        }
        ) {
            throw RuntimeException(NOT_ALLOW_LETTER_OR_NEGATIVE)
        }
    }
}
