package calculator

object InputParser {
    private val defaultDelimiterRegex = "[,:]".toRegex()
    private val CustomDelimiterRegex = Regex("//(.)\n(.*)")
    private const val FIRST_INDEX = 0
    private const val CUSTOM_DELIMITER_INDEX = 1
    private const val CUSTOM_EXPRESSION_INDEX = 2
    fun parse(input: String): List<String> {
        if (isParsableByDefaultDelimiter(input)) {
            return parseByDefaultDelimiter(input)
        }
        return parseByCustomDelimiter(input)
    }

    private fun isParsableByDefaultDelimiter(input: String): Boolean {
        val tokens = parseByDefaultDelimiter(input)
        if (tokens[FIRST_INDEX] != input) {
            return true
        }
        return tokens[FIRST_INDEX] == input && tokens[FIRST_INDEX].toIntOrNull() != null
    }

    private fun parseByDefaultDelimiter(input: String): List<String> {
        return input.split(defaultDelimiterRegex)
    }

    private fun parseByCustomDelimiter(input: String): List<String> {
        CustomDelimiterRegex.find(input)?.let { result ->
            val customDelimiter = result.groupValues[CUSTOM_DELIMITER_INDEX]
            return result.groupValues[CUSTOM_EXPRESSION_INDEX].split(customDelimiter)
        } ?: return listOf()
    }
}
