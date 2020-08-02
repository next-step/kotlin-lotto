package calculator

class InputParser(private val text: String) {
    var numbersParsed: List<Int>
        private set

    init {
        numbersParsed = numbersFrom(text)
    }

    private fun numbersFrom(text: String): List<Int> {
        val result = CUSTOM_PATTERN.toRegex().find(text)
        var token = text
        var customDelimiter = DELIMITER_COMMA

        result?.let {
            customDelimiter = customDelimiter(result)
            token = result.groupValues[2]
        }

        val numbers = splitFrom(token, customDelimiter)
        return numbers
    }

    private fun splitFrom(text: String, custom: String): List<Int> {
        val tokens = text.split(DELIMITER_COMMA, DELIMITER_COLON, custom)
        checkIllegalInput(tokens)

        return tokens.map { it.toInt() }
    }

    private fun customDelimiter(result: MatchResult): String = result.groupValues[1]

    private fun checkIllegalInput(tokens: List<String>) {
        if (tokens.any {
                it.toIntOrNull() == null ||
                    it.toInt() < 0
            }
        ) {
            throw RuntimeException(NOT_ALLOW_LETTER_OR_NEGATIVE)
        }
    }

    companion object {
        private const val DELIMITER_COMMA = ","
        private const val DELIMITER_COLON = ":"
        private const val CUSTOM_PATTERN = "//(.)\\\\n(.*)"
        private const val NOT_ALLOW_LETTER_OR_NEGATIVE = "숫자 이외의 값 또는 음수 입력 불가"
    }
}
