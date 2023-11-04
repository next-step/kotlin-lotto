package calculator

object StringInputParser {
    private val DELIMITERS_REGEX = Regex("[,:]")
    private val CUSTOM_DELIMITER_MATCH_REGEX = Regex("//(.)\n(.*)")

    fun parse(input: String): Operands {
        val customDelimiterMatchResult = CUSTOM_DELIMITER_MATCH_REGEX.find(input)

        val splitInput = splitInput(input, customDelimiterMatchResult)

        return Operands(
            numbers = splitInput.map {
                requireNotNull(it.toIntOrNull()) { "숫자 이외의 값은 계산할 수 없습니다." }
            },
        )
    }

    private fun splitInput(input: String, customDelimiterMatchResult: MatchResult?): List<String> {
        return if (customDelimiterMatchResult != null) {
            val (customDelimiter, inputExceptCustomText) = customDelimiterMatchResult.destructured
            inputExceptCustomText.split(customDelimiter)
        } else {
            input.split(DELIMITERS_REGEX)
        }
    }
}
