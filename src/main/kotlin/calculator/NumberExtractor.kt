package calculator

class NumberExtractor {

    private fun buildCustomSeperator(inputExpression: String): String {
        val matchResult = CUSTOM_SEPERATOR_EXPRESSION_REGEX.find(inputExpression) ?: return ""
        return matchResult.groupValues[1]
    }

    private fun getSeparators(inputExpression: String): Array<String> {
        val customSeperator = buildCustomSeperator(inputExpression)
        return if (customSeperator.isNotEmpty()) {
            arrayOf(COMMA_SEPERATOR, COLON_SEPERATOR, customSeperator[0].toString())
        } else {
            arrayOf(COMMA_SEPERATOR, COLON_SEPERATOR)
        }
    }

    fun extractNumbers(inputExpression: String): List<String> =
        CUSTOM_SEPERATOR_EXPRESSION_REGEX.replace(inputExpression, "").split(*getSeparators(inputExpression))

    companion object {
        private const val COMMA_SEPERATOR = ","
        private const val COLON_SEPERATOR = ":"
        private val CUSTOM_SEPERATOR_EXPRESSION_REGEX = Regex("""//(.+?)\n""")
    }
}
