package stringPlusCalculator

class CustomStringParser {
    companion object {
        fun parse(expressionInput: String): List<String> {
            val stringExpression = findStringExpression(expressionInput)
            val customStringParser = findCustomStringParser(expressionInput)

            return when {
                customStringParser.isNullOrBlank() -> listOf(stringExpression)
                else -> stringExpression.split(customStringParser)
            }
        }

        private fun findCustomStringParser(expressionInput: String): String {
            return CustomStringParserFinder.find(expressionInput)
        }

        private fun findStringExpression(expressionInput: String): String {
            return expressionInput.substringAfter("\n")
        }
    }
}
