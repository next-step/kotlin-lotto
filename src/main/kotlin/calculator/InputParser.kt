package calculator

object InputParser {
    private const val DEFAULT_DELIMITER_REGEX = ",|:"
    private const val CUSTOM_DELIMITER_KEYWORD = "//(.)\\n(.*)"

    private fun extractNumbers(
        input: String,
        delimiter: String = DEFAULT_DELIMITER_REGEX,
    ): Numbers = Numbers(input.split(delimiter.toRegex()).map { Number(it.toInt()) })

    fun parse(input: String?): Numbers {
        if (input.isNullOrBlank()) {
            return Numbers(emptyList())
        }

        val matchResults = Regex(CUSTOM_DELIMITER_KEYWORD).find(input)

        if (matchResults != null) {
            return extractNumbers(input = matchResults.groupValues[2], delimiter = matchResults.groupValues[1])
        }

        return extractNumbers(input)
    }
}
