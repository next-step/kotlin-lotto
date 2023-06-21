package calculator

class StringParser {
    fun parsingNumbers(text: String, parsingRegex: ParsingRegex = DefaultParsingRegex()): PositiveNumbers {
        val result = parsingRegex.find(text)
        result?.let {
            val customDelimiter = it.groupValues[DELIMITER_INDEX]
            val strings = it.groupValues[EXPRESSION_INDEX].split(customDelimiter)
            return PositiveNumbers.fromStrings(strings)
        }

        val strings = text.split(DEFAULT_DELIMITER_REGEX)
        return PositiveNumbers.fromStrings(strings)
    }

    companion object {
        private const val DELIMITER_INDEX = 1
        private const val EXPRESSION_INDEX = 2
        private val DEFAULT_DELIMITER_REGEX = Regex("[,:]")
    }
}
