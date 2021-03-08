package stringaddcalculator.util

class ExpressionParser {

    companion object {
        const val CUSTOM_PARSE_PATTERN = "//(.)\n(.*)"
    }

    fun parse(calculationInput: String): List<String> {
        val parseInput = findPattern(calculationInput) ?: return Splitter().split(calculationInput)
        return Splitter(parseInput.delimiter).split(parseInput.input)
    }

    private fun findPattern(input: String): ParserResult? {
        val result = Regex(CUSTOM_PARSE_PATTERN).find(input)
        result?.let {
            val customDelimiter = it.groupValues[1]
            val tokens = it.groupValues[2]
            return ParserResult(customDelimiter, tokens)
        }
        return null
    }

    private data class ParserResult(val delimiter: String, val input: String)
}
