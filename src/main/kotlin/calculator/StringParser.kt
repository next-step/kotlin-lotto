package calculator

object StringParser {
    private val BASE_DELIMITERS = arrayOf(",", ";")
    private const val CUSTOM_DELIMITER_INDEX = 1
    private const val NUMBER_STRING_INDEX = 2

    fun getNumberStrings(input: String): List<String> {
        val matcherResult = CustomDelimiterFinder.find(input)

        return if (matcherResult != null) {
            val delimiter = matcherResult.groupValues[CUSTOM_DELIMITER_INDEX]
            val numberStrings = matcherResult.groupValues[NUMBER_STRING_INDEX]
            numberStrings.splitAsDelimiter(BASE_DELIMITERS + delimiter)
        } else {
            input.splitAsDelimiter(BASE_DELIMITERS)
        }
    }

    private fun String.splitAsDelimiter(delimiters: Array<String>): List<String> {
        return this.split(*delimiters)
    }
}
