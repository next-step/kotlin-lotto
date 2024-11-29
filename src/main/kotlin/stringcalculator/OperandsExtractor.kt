package stringcalculator

object OperandsExtractor {
    private const val DEFAULT_DELIMITERS = ",|:"
    private const val CUSTOM_DELIMITER_FIRST_INDICATOR = "//"
    private const val CUSTOM_DELIMITER_SECOND_INDICATOR = "\n"
    private val inputRegex = Regex("$CUSTOM_DELIMITER_FIRST_INDICATOR(.)$CUSTOM_DELIMITER_SECOND_INDICATOR(.*)")

    fun extract(input: String): List<Int> {
        val (delimiters, expression) = getExpressionInfo(input)
        return ExpressionParser.parseToInts(expression, delimiters)
    }

    private fun getExpressionInfo(input: String): ExpressionInfo =
        if (input.startsWith(CUSTOM_DELIMITER_FIRST_INDICATOR)) {
            val matchResult = inputRegex.find(input) ?: throw RuntimeException("커스텀 구분자 설정이 제대로 되지 않았습니다")
            val customDelimiter = matchResult.groupValues[1]
            val expression = matchResult.groupValues[2]

            ExpressionInfo(getCustomDelimiterRegex(customDelimiter), expression)
        } else {
            ExpressionInfo(getDefaultDelimiterRegex(), input)
        }

    private fun getDefaultDelimiterRegex() = DEFAULT_DELIMITERS.toRegex()

    private fun getCustomDelimiterRegex(customDelimiter: String) = "$customDelimiter|$DEFAULT_DELIMITERS".toRegex()
}
