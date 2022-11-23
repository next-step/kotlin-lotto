package stringPlusCalculator

import stringPlusCalculator.exception.CustomParserNotExistsException

class CustomStringParserFinder {
    fun find(expressionInput: String): String {
        return try {
            if (!hasCustomStringParser(expressionInput)) throw CustomParserNotExistsException()

            expressionInput.substringAfter("//").substringBefore("\n")
        } catch (e: CustomParserNotExistsException) {
            ""
        }
    }

    private fun hasCustomStringParser(expressionInput: String): Boolean {
        return validateCustomStringParserCondition(expressionInput)
    }

    private fun validateCustomStringParserCondition(expressionInput: String): Boolean {
        return expressionInput.contains("//") && expressionInput.contains("\n")
    }
}
