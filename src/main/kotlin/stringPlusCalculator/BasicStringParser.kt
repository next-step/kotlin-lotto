package stringPlusCalculator

class BasicStringParser {
    fun parse(expressionInput: String): List<String> {
        return expressionInput.split(",|:".toRegex())
    }
}