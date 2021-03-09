package calculator

class Token(input: String) {

    val values: List<String>

    init {
        require(input.isNotBlank()) { "문자열은 공백일 수 없습니다. input: $input" }

        values = REGEX.find(input)?.let {
            val (_, delimiter, tokenStr) = it.groupValues
            tokenStr.split(delimiter)
        } ?: input.split(DEFAULT_DELIMITER_COMMA, DEFAULT_DELIMITER_COLON)
    }

    companion object {
        private val REGEX: Regex =
            """//(.)\n(.*)""".toRegex()
        private const val DEFAULT_DELIMITER_COMMA = ","
        private const val DEFAULT_DELIMITER_COLON = ":"
    }
}
