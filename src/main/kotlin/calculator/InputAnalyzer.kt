package calculator

class InputAnalyzer(private var inputString: String) {
    private val delimiters: MutableList<String> = DEFAULT_DELIMITER.toMutableList()

    init {
        extractCustomDelimiter()
    }

    private fun extractCustomDelimiter() {
        val delimiterMatch = CUSTOM_DELIMITER_PATTERN.find(inputString)

        delimiterMatch?.let {
            delimiters.add(it.groupValues[1])
            this.inputString = it.groupValues[2]
        }
    }

    fun extractNumbers(): List<Int> {
        return inputString.split(*delimiters.toTypedArray())
            .map { it.toInt() }
    }

    fun validateInput() {
        inputString.split(*delimiters.toTypedArray()).forEach { token ->
            validateIsNumeric(token)
            validateIsNonNegative(token.toInt())
        }
    }

    private fun validateIsNumeric(token: String) {
        if (token.toIntOrNull() == null) {
            throw RuntimeException("입력 값은 쉼표(,), 콜론(:), 커스텀 구분자를 제외한 나머지 문자는 모두 숫자로 입력해야 합니다.")
        }
    }

    private fun validateIsNonNegative(number: Int) {
        if (number < 0) {
            throw RuntimeException("입력 값은 음수가 아니어야 합니다.")
        }
    }

    companion object {
        private val DEFAULT_DELIMITER = listOf(",", ":")
        private val CUSTOM_DELIMITER_PATTERN = Regex("""//(.*)\\n(.*)""")
    }
}
