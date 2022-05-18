class InputParser {
    fun parse(input: String, delimiters: String = DEFAULT_DELIMITER): List<String> {
        val customDelimiterMatch = "//(.)\n(.*)".toRegex().find(delimiters) ?: return parse(input, delimiters.toRegex())

        val delimiter = customDelimiterMatch.groupValues[1]
        return customDelimiterMatch.groupValues[2].split(delimiter)
    }

    private fun parse(input: String, delimiter: Regex): List<String> {
        return input.split(delimiter)
    }

    companion object {
        const val DEFAULT_DELIMITER = ",|:"
    }
}
