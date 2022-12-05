package stringPlusCalculator

class BasicStringParser {
    companion object {
        fun parse(expressionInput: String): List<String> {
            return expressionInput.split(",|:".toRegex())
        }
    }
}
