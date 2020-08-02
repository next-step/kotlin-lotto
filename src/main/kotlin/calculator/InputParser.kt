package calculator

private const val COMMA = ","
private const val COLON = ":"
private const val CUSTOM_PATTERN = "//(.)\\\\n(.*)"
private const val NOT_ALLOW_LETTER_OR_NEGATIVE = "숫자 이외의 값 또는 음수 입력 불가"
private val customRegex: Regex = CUSTOM_PATTERN.toRegex()

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
        if (hasIllegalToken(tokens)) throw RuntimeException(NOT_ALLOW_LETTER_OR_NEGATIVE)
    }

    private fun hasIllegalToken(tokens: List<String>) =
        tokens.any { it.toIntOrNull() == null || it.toInt() < 0 }
}
