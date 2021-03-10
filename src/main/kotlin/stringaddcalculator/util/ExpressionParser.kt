package stringaddcalculator.util

object ExpressionParser {

    private const val CUSTOM_PARSE_PATTERN = "//(.)\n(.*)"
    private val regexPattern = Regex(CUSTOM_PARSE_PATTERN)

    fun parse(calculationInput: String): List<String> {
        val parseInput = findPattern(calculationInput) ?: return Splitter().split(calculationInput)
        return Splitter(parseInput.delimiter).split(parseInput.input)
    }

    private fun findPattern(input: String): ParserResult? {
        val result = regexPattern.find(input)
        result?.let {
            val (customDelimiter, tokens) = it.destructured
            return ParserResult(customDelimiter, tokens)
        }
        return null
    }

    private data class ParserResult(val delimiter: String, val input: String)
}
