package calculator

object CustomDelimiterFinder {
    private const val CUSTOM_DELIMITER_POSITION = 1

    fun find(input: String, regex: Regex): String? {
        return regex.find(input)?.let { matchResult ->
            matchResult.groupValues[CUSTOM_DELIMITER_POSITION]
        }
    }
}
