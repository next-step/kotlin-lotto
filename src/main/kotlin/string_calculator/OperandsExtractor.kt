package string_calculator

interface OperandsExtractor {
    fun extract(input: String): List<Int>
}

class OperandsExtractorImpl : OperandsExtractor {
    override fun extract(input: String): List<Int> {
        val (delimiters: Regex, expression: String) =
            getExpressionInfo(input)

        return ExpressionParser.parseToInts(expression, delimiters)
    }

    private fun getExpressionInfo(input: String): Pair<Regex, String> =
        if (input.startsWith(CUSTOM_DELIMITER_FIRST_INDICATOR)) {
            val matchResult = inputRegex.find(input) ?: throw RuntimeException("커스텀 구분자 설정이 제대로 되지 않았습니다")
            val customDelimiter = matchResult.groupValues[1]
            val expression = matchResult.groupValues[2]

            getCustomDelimiterRegex(customDelimiter) to expression
        } else {
            getDefaultDelimiterRegex() to input
        }

    private fun getDefaultDelimiterRegex() =
        DEFAULT_DELIMITERS.toRegex()

    private fun getCustomDelimiterRegex(customDelimiter: String) =
        "$customDelimiter|$DEFAULT_DELIMITERS".toRegex()

    private companion object {
        const val DEFAULT_DELIMITERS = ",|:"
        const val CUSTOM_DELIMITER_FIRST_INDICATOR = "//"
        const val CUSTOM_DELIMITER_SECOND_INDICATOR = "\n"
        val inputRegex = Regex("$CUSTOM_DELIMITER_FIRST_INDICATOR(.)$CUSTOM_DELIMITER_SECOND_INDICATOR(.*)")
    }
}