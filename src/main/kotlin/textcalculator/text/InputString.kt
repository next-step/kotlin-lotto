package textcalculator.text

class InputString(
    originalInput: String,
    initialDelimiters: List<String> = listOf(",", ":")
) {
    val input: String
    val delimiters: List<String>

    init {
        val (customDelimiter, customInput) = extractCustomInput(originalInput)

        this.delimiters = if (customDelimiter.isNotEmpty()) {
            initialDelimiters + customDelimiter
        } else {
            initialDelimiters
        }

        if (customDelimiter.isNotEmpty()) {
            validate(customInput, customDelimiter)
            this.input = customInput
        } else {
            validate(originalInput)
            this.input = originalInput
        }
    }

    private fun extractCustomInput(input: String): Pair<String, String> {
        return CUSTOM_DELIMITER_CHECK.find(input)?.let {
            it.groupValues[1] to it.groupValues[2]
        } ?: ("" to input)
    }

    private fun validate(input: String, customDelimiter: String = "") {
        if (NEGATIVE_NUMBER_CHECK.matches(input)) {
            throw RuntimeException("문자열 계산기에 음수를 전달할 수 없습니다.")
        }

        val pattern = if (customDelimiter.isNotEmpty()) {
            """^[0-9,: \t\n\r${Regex.escape(customDelimiter)}]+$""".toRegex()
        } else {
            ALLOWED_STRING_CHECK
        }

        if (!pattern.matches(input)) {
            throw RuntimeException("문자열 계산기에 쉼표와 콜론 이외의 문자가 들어올 수 없습니다.")
        }
    }

    companion object {
        private val ALLOWED_STRING_CHECK = """^[0-9,: \t\n\r]+$""".toRegex()
        private val NEGATIVE_NUMBER_CHECK = """-\d+""".toRegex()
        private val CUSTOM_DELIMITER_CHECK = """//(.|[\s])\n(.*)""".toRegex()
    }
}
