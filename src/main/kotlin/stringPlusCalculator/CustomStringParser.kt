package stringPlusCalculator

class CustomStringParser {
    fun parse(expressionInput: String): List<String> {
        val stringExpression = findStringExpression(expressionInput)

        return try {
            val customStringParser = findCustomStringParse(expressionInput)
            if(customStringParser.isNullOrBlank()) throw IllegalArgumentException("커스텀 구분자가 존재하지 않습니다.")

            stringExpression.split(customStringParser)
        } catch (e: IllegalArgumentException) {
            listOf(stringExpression)
        }
    }

    private fun findCustomStringParse(expressionInput: String): String {
        val customStringParserFinder = CustomStringParserFinder()

        return customStringParserFinder.find(expressionInput)
    }

    private fun findStringExpression(expressionInput: String): String {
        return expressionInput.substringAfter("\n")
    }
}