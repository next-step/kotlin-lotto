package calculator


object Parser {

    private const val CUSTOM_REGEX_PATTERN = "^//(.)\\n(.*)$"
    private const val COMMA = ","
    private const val COLON = ":"

    fun parse(input: String?): List<Int> {
        if (input.isNullOrBlank()) return listOf(0)

        return (CUSTOM_REGEX_PATTERN.toRegex().find(input)?.groupValues?.let {
            it[2].split(it[1], COMMA, COLON)
        } ?: input.split(COMMA, COLON))
            .map { it.toInt() }
            .filter { it.isPositiveNumber() }

    }

    private fun Int.isPositiveNumber(): Boolean {
        require(this > 0) { "양수만 입력할 수 있습니다." }
        return true
    }
}
