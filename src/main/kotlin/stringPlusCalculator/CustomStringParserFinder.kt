package stringPlusCalculator

class CustomStringParserFinder {
    fun find(expressionInput: String): String {
        val customStringParser = try {
            if(!hasCustomStringParser(expressionInput)) throw IllegalArgumentException("커스텀 구분자가 존재하지 않습니다.")

            expressionInput.substringAfter("//").substringBefore("\n")
        } catch (e: IllegalArgumentException) {
            ""
        }

        return customStringParser
    }

    private fun hasCustomStringParser(expressionInput: String): Boolean {
        return validateCustomStringParserCondition(expressionInput)
    }

    private fun validateCustomStringParserCondition(expressionInput: String): Boolean {
        return expressionInput.contains("//") && expressionInput.contains("\n")
    }
}