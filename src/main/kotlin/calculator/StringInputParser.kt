package calculator

object StringInputParser {
    private val DELIMITERS_REGEX = Regex("[,:]")
    private val CUSTOM_DELIMITER_MATCH_REGEX = Regex("//(.)\n(.*)")

    fun parse(input: String): Operands {
        val customDelimiterMatchResult = CUSTOM_DELIMITER_MATCH_REGEX.find(input)

        val splitInput = if (customDelimiterMatchResult != null) {
            val customDelimiter = customDelimiterMatchResult.groupValues[1]
            customDelimiterMatchResult.groupValues[2].split(customDelimiter)
        } else {
            input.split(DELIMITERS_REGEX)
        }

        return Operands(
            numbers = splitInput.map {
                it.toIntOrNull() ?: throw RuntimeException("숫자 이외의 값은 계산할 수 없습니다.")
            },
        )
    }
}
